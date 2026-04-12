package com.pm.patientservice.Exception;

public class EmailNotExistEception extends RuntimeException {
    public EmailNotExistEception(String message) {
        super(message);
    }
}
