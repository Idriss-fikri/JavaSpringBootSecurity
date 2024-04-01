package com.example.reviewsmysql.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CodeExpiredExeption  extends ResponseStatusException {
    public CodeExpiredExeption() {
        super(HttpStatus.BAD_REQUEST, "Code is invalid");
    }
}
