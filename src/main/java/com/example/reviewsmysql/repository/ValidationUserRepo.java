package com.example.reviewsmysql.repository;

import com.example.reviewsmysql.entity.User;
import com.example.reviewsmysql.entity.ValidationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ValidationUserRepo  extends JpaRepository<ValidationUser, Long> {
     Optional<ValidationUser> findByCode(String code);


}
