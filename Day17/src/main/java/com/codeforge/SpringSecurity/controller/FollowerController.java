package com.codeforge.SpringSecurity.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeforge.SpringSecurity.model.User;
import com.codeforge.SpringSecurity.repository.UserRepository;
import com.codeforge.SpringSecurity.request.FollowerRequestDto;
import com.codeforge.SpringSecurity.service.FollowerService;

@RestController
@RequestMapping("/api/v1/followers")
public class FollowerController {
    @Autowired
    private FollowerService followerService;
    @PostMapping("/follow")
    public ResponseEntity<String> followUser(@RequestBody FollowerRequestDto request) {
        Long followerId = request.getFollowerId();
        Long followingId = request.getFollowingId();

        followerService.followUser(followerId, followingId);

        return ResponseEntity.ok("Successfully followed user");
    }

    @PostMapping("/unfollow")
    public ResponseEntity<String> unfollowUser(@RequestBody FollowerRequestDto request) {
        Long followerId = request.getFollowerId();
        Long followingId = request.getFollowingId();

        followerService.unfollowUser(followerId, followingId);

        return ResponseEntity.ok("Successfully unfollowed user");
    }
}
