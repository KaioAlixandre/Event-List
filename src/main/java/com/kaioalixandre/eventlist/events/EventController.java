package com.kaioalixandre.eventlist.events;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaioalixandre.eventlist.utils.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EventRepository repository;

    @PostMapping("/create")
    public ResponseEntity<EventModel> create(@RequestBody EventModel event, HttpServletRequest request) {
        UUID idUser = (UUID) request.getAttribute("idUser");
        event.setUserId(idUser);
        
        var savedEvent = repository.save(event);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody EventModel event, HttpServletRequest request) {
        UUID idUser = (UUID) request.getAttribute("idUser");

        var existing = repository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var dbEvent = existing.get();
        if (!dbEvent.getUserId().equals(idUser)) {
            return ResponseEntity.status(403).body("Você não pode editar esse evento");
        }

        event.setId(id);
        event.setUserId(idUser);
        return ResponseEntity.ok(repository.save(event));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id, HttpServletRequest request) {
        UUID idUser = (UUID) request.getAttribute("idUser");

        var existing = repository.findById(id);
        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var dbEvent = existing.get();
        if (!dbEvent.getUserId().equals(idUser)) {
            return ResponseEntity.status(403).body("Você não pode excluir esse evento");
        }

        repository.delete(dbEvent);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public List<EventModel> getEvents(HttpServletRequest request) {
        UUID idUser = (UUID) request.getAttribute("idUser");
        return repository.findByUserId(idUser);
    }
}


