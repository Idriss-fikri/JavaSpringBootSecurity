package com.example.reviewsmysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ValidationUser")
public class ValidationUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id ;
    @Column(name = "date de creation ")
    Instant CreationDate ;
    @Column(name = "date d'expiration ")
    Instant ExpireDate ;
    @OneToOne(cascade = CascadeType.ALL)
    User user ;
    @Column(name = "code d'activation")
    String ActivationCode ;

}
