package com.codeforge.SpringSecurity.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeforge.SpringSecurity.model.Follower;
import com.codeforge.SpringSecurity.model.User;
import com.codeforge.SpringSecurity.repository.FollowerRepository;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    public Follower followUser(Long followerId, Long followingId) {
        Follower userFollow = new Follower();
        userFollow.setFollowerId(followerId);
        userFollow.setFollowingId(followingId);
        return followerRepository.save(userFollow);
    }
    public void unfollowUser(Long followerId, Long followingId) {
        Follower follow = followerRepository.findByFollowerIdAndFollowingId(followerId, followingId);
        if (follow != null) {
            followerRepository.delete(follow);
        }
    }

    public boolean isFollowing(Long followerId, Long followingId) {
        return followerRepository.existsByFollowerIdAndFollowingId(followerId, followingId);
    }
}

