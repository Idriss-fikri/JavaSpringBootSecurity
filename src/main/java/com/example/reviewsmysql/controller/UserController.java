package com.example.reviewsmysql.controller;

import com.example.reviewsmysql.dto.UserDto;
import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.service.userService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {
    private userService userService;

    //controller for   user inscription
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/inscription")
    public void inscription(@RequestBody User user) {

        this.userService.SignUser(user);
    }

    // controller for activate user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/activation")
    public void activation(@RequestBody Map<String, String> activation) {
        this.userService.activation(activation);

    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(path = "/user/{id}")
    public UserDto getUserById(@PathVariable Long id) { // pathvariable taking the id from link (taking = extract )
        return this.userService.getUserById(id);
    }

}


