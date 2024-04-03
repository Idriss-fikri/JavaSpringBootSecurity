package com.example.reviewsmysql.service;

import com.example.reviewsmysql.entity.ValidationUser;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class mailSenderService {
    JavaMailSender javaMailSender ;
    public  void SendEmail (ValidationUser validationUser){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("no-reply@fikri.fr");
        simpleMailMessage.setTo(validationUser.getUser().getEmail());
        simpleMailMessage.setSubject("Votre code d'activation pour valider votre compte");
        String messagemail = String.format("Bonjour %s,\n\nVoici votre code d'activation : %s",
                validationUser.getUser().getFirstname(),
                validationUser.getCode());

        simpleMailMessage.setText(messagemail);

        javaMailSender.send(simpleMailMessage);

    }
}
