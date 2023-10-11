package com.codeforge.SpringSecurity.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeforge.SpringSecurity.model.Follower;


public interface FollowerRepository extends JpaRepository<Follower, Long> {

    List<Follower> findByUserId(Long userId);

   
}
