package com.codeforge.SpringSecurity.controller;

import com.codeforge.SpringSecurity.model.Follower;
import com.codeforge.SpringSecurity.request.FollowerRequestDto;
import com.codeforge.SpringSecurity.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/followers")
public class FollowerController {
    private final FollowerService followerService;

    @Autowired
    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping("/follow")
    public void followUser(@RequestBody FollowerRequestDto followerRequest) {
        Follower follower = new Follower();
        // Set the user and followerId based on the provided data
        follower.setUser(followerRequest.getUserId());
        follower.setFollowerId(followerRequest.getFollowerId());
        followerService.saveFollower(follower);
    }

    @GetMapping("/followersList")
    public List<Follower> getFollowers(@RequestParam("userId") Long userId) {
        // Implement logic to fetch followers based on the given userId
        return followerService.getFollowersByUserId(userId);
    }
}
