package org.example.task1.exception;

public class InvalidBracketCountException extends RuntimeException {
    public InvalidBracketCountException(String message) {
        super(message);
    }
}
