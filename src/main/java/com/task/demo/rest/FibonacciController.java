package com.task.demo.rest;

import com.task.demo.entity.Fibonacci;
import com.task.demo.repository.FibonacciRepository;
import com.task.demo.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class FibonacciController {

    @Autowired
    private FibonacciRepository repository;

    @Autowired
    private FibonacciService service;

    @PostMapping("/fib")
    public Fibonacci saveSequence(@RequestBody Fibonacci sequence) {
        return service.addReverseSequenceIfFibonacci(sequence);
    }

    @GetMapping("/fib")
    public List<Fibonacci> findAll() {
        return service.findAll();
    }
}
