package com.example.reviewsmysql.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserAlreadyExist  extends ResponseStatusException {
    public UserAlreadyExist() {
        super(HttpStatus.BAD_REQUEST, "User Already exist");
    }
}
