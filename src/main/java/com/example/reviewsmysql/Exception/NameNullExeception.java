package com.example.reviewsmysql.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NameNullExeception  extends ResponseStatusException {
    public NameNullExeception() {
            super(HttpStatus.BAD_REQUEST, "Name cannot be null");
        }

    }

