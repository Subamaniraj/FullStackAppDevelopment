package com.codeforge.SpringSecurity.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforge.SpringSecurity.model.Follower;


@Repository
public interface FollowerRepository extends JpaRepository<Follower, Long> {

    Follower findByFollowerIdAndFollowingId(Long followerId, Long followingId);

    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);
}

