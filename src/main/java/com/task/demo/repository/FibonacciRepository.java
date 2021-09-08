package com.task.demo.repository;

import com.task.demo.entity.Fibonacci;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FibonacciRepository extends MongoRepository<Fibonacci, UUID> {
}
