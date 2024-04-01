package com.example.reviewsmysql.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoCodeFindExeception   extends ResponseStatusException {
    public NoCodeFindExeception() {
        super(HttpStatus.BAD_REQUEST, "Code invalid");
    }
}
