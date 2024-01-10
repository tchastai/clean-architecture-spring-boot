package com.cleanarchitecture.exception;

public class DomainException extends RuntimeException {
    public DomainException(final String message) {
        super(message);
    }
}
