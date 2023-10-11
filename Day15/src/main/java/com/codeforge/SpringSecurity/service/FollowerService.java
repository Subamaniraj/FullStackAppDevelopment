package com.codeforge.SpringSecurity.service;
import java.util.*;
import com.codeforge.SpringSecurity.model.Follower;

public interface FollowerService {
    void saveFollower(Follower follower);
    
    List<Follower> getFollowersByUserId(Long userId);
}
