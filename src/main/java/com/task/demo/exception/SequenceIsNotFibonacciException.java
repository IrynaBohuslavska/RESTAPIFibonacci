package com.task.demo.exception;

public class SequenceIsNotFibonacciException extends RuntimeException {
    public SequenceIsNotFibonacciException(String message) {
        super(message);
    }
}
