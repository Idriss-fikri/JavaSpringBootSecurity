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
    @Column(name = "creation_date ")
    Instant CreationDate ;
    @Column(name = "expire_date ")
    Instant ExpireDate ;
    @OneToOne(cascade = CascadeType.ALL)
    User user ;
    @Column(name = "activation_code")
    String code;

}
