package com.example.reviewsmysql.service;

import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.entity.ValidationUser;
import com.example.reviewsmysql.repository.ValidationUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@Service
@AllArgsConstructor
public class ValidationUserService {
    private  final ValidationUserRepo validationUserRepo ;
    private  final mailSenderService mailSenderService ;




    public  void ValidationUserInscription(User user){
        ValidationUser validationUser =  new ValidationUser();
        validationUser.setUser(user);
        Instant creationDate = Instant.now() ;
        Instant expirationDate= creationDate.plus(10, ChronoUnit.MINUTES);
        validationUser.setCreationDate(creationDate);
        validationUser.setExpireDate(expirationDate);
        Random random = new Random() ;
        Integer randomInteger =random.nextInt(999999);
        String code = String.format("%06d",randomInteger);
        validationUser.setActivationCode(code);
        this.validationUserRepo.save(validationUser);
        this.mailSenderService.SendEmail(validationUser);

    }
    // after validation of the user  we need to send him  an email  with the code of activation , we will  send him an email  with javamailsender



}
