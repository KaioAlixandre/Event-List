package com.kaioalixandre.eventlist.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaioalixandre.eventlist.utils.JwtUtil;

import at.favre.lib.crypto.bcrypt.BCrypt;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private IUserRepository repository;

    @PostMapping("/create")
    public ResponseEntity createuser(@RequestBody UserModel user){
        var userExists = this.repository.findByUsername(user.getUsername());
        if(userExists != null){
            return ResponseEntity.status(400).body("Username already exists");
        }
        var userPassword = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
        user.setPassword(userPassword);

        var userSaved = this.repository.save(user);
        return ResponseEntity.status(200).body(userSaved);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel user) {
        var userExists = repository.findByUsername(user.getUsername());
        if (userExists == null) {
            return ResponseEntity.status(401).body("User not found");
        }

        var result = BCrypt.verifyer().verify(user.getPassword().toCharArray(), userExists.getPassword());
        if (!result.verified) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = JwtUtil.generateToken(userExists.getId());
        return ResponseEntity.ok(token);
}
    
}
