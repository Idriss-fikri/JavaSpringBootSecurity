package com.example.reviewsmysql.controller;

import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.service.userService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final userService userService ;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "inscription")
    public void inscription(@RequestBody User user) {

        this.userService.SignUser(user);
    }

}
