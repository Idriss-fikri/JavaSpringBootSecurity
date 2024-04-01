package com.example.reviewsmysql.controller;

import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.service.userService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class UserController {
    private  userService userService ;

    //controller for   user inscription
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/inscription")
    public void inscription(@RequestBody User user) {

        this.userService.SignUser(user);
    }
    // controller for activate user
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/activation")
    public  void activation(@RequestBody Map<String ,  String> activation){
            this.userService.activation(activation);

    }
}
