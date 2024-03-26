package com.example.reviewsmysql.entity;

import com.example.reviewsmysql.TypeRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id ;
    @Enumerated(EnumType.STRING) //  je dis je veux stoquer mes roles en tant que chaine de caractere
    private TypeRole role ;


}
