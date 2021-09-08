package com.task.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Fibonacci {

    @Id
    private UUID id = UUID.randomUUID();
    private String sequence;

    public Fibonacci() {
    }

    public Fibonacci(String sequence) {
        this.sequence = sequence;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
