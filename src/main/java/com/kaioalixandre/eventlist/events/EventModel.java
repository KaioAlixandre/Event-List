package com.kaioalixandre.eventlist.events;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="events")
public class EventModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String tarefa;

    @CreationTimestamp
    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;

    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Construtor padrão obrigatório para JPA
    public EventModel() {}

    // Construtor customizado
    public EventModel(LocalDateTime dataFinal, String tarefa) {
        this.dataInicial = LocalDateTime.now();
        this.dataFinal = dataFinal;
        this.tarefa = tarefa;
    }

    // Método utilitário de contagem regressiva
    public String contadorFormatado() {
        Duration dur = Duration.between(LocalDateTime.now(), dataFinal);

        long dias = dur.toDays();
        long horas = dur.minusDays(dias).toHours();
        long minutos = dur.minusDays(dias).minusHours(horas).toMinutes();

        return "Faltam " + dias + " dias, " + horas + " horas e " + minutos + " minutos para " + tarefa;
    }

    // Getters e Setters
    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

	public UUID getUserId() {
		return userId;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	
}
