package com.example.reviewsmysql.service;

import com.example.reviewsmysql.Exception.EmailNullException;
import com.example.reviewsmysql.Exception.InvalidEmailException;
import com.example.reviewsmysql.Exception.NameNullExeception;
import com.example.reviewsmysql.Exception.UserAlreadyExist;
import com.example.reviewsmysql.TypeRole;
import com.example.reviewsmysql.entity.Role;
import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class userService {
    private  final UserRepo userRepo ;
    private BCryptPasswordEncoder passwordEncoder ;

    public  void  SignUser(User user ){
        ValidatorsField( user);
        String password = user.getPassword();
        String passwordEncode =  this.passwordEncoder.encode(password);
        user.setPassword(passwordEncode);
        Role role=new Role();
        role.setRole(TypeRole.USER ); // somene who sign he is a user
        user.setRole(role);
        this.userRepo.save(user);
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
}
