package com.example.reviewsmysql.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailNullException  extends ResponseStatusException {
    public EmailNullException() {
        super(HttpStatus.BAD_REQUEST, "Email  cannot be blank");
    }

    }
