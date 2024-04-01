package com.example.reviewsmysql.service;

import com.example.reviewsmysql.Exception.*;
import com.example.reviewsmysql.TypeRole;
import com.example.reviewsmysql.entity.Role;
import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.entity.ValidationUser;
import com.example.reviewsmysql.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.Optional;
@AllArgsConstructor
@Service
public class userService {
    private   UserRepo userRepo ;
    private BCryptPasswordEncoder passwordEncoder ;

    private  ValidationUserService  validationUserService ;


    public  void  SignUser(User user ){
        ValidatorsField( user);
        String password = user.getPassword();
        String passwordEncode =  this.passwordEncoder.encode(password);
        user.setPassword(passwordEncode);
        Role role=new Role();
        role.setRole(TypeRole.USER ); // somene who sign he is a user
        user.setRole(role);
        this.userRepo.save(user);
        this.validationUserService.ValidationUserInscription(user);

    }

    public  void  ValidatorsField(User user){
        Optional<User> userfindnbyEmail = this.userRepo.findByEmail(user.getEmail());
        if ( userfindnbyEmail.isPresent() ) {
            throw  new UserAlreadyExist();
        }
        if ( user.getName().isBlank() && user.getName().equals("") && user.getName().isEmpty()){
            throw  new NameNullExeception();
        }
        if ( !user.getEmail().contains("@") ){
            throw  new InvalidEmailException();
        }
        if ( !user.getEmail().contains(".") ){
            throw  new InvalidEmailException();
        }
        if ( user.getEmail().isBlank()){
            throw  new EmailNullException();
        }

    }

    public void activation(Map<String, String> activation) {
        ValidationUser validation = this.validationUserService.getCode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpireDate())){
            throw  new CodeExpiredExeption();
        }
        User utilisateurActiver = this.userRepo.findById(validation.getUser().getId()).orElseThrow(() ->

                new NoUserFoundException());
        utilisateurActiver.setActif(true);
        this.userRepo.save(utilisateurActiver);
    }
}
