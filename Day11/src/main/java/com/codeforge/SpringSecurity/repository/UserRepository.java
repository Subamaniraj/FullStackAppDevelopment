package com.codeforge.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeforge.SpringSecurity.model.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByName(String name);
    
}
