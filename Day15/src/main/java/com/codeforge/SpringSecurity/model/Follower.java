package com.codeforge.SpringSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor // Added a no-args constructor
@Entity
@Table(name="_followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user; // This should be correctly set using JPA relationship

    // Getter and Setter for user

    // Implement logic to set the user based on the given userId
    public void setUser(Long long1) {
        this.user = long1;
    }

    private Long followerId; // Change this to the correct data type if necessary

    // Getter and Setter for followerId

    // Implement logic to set the followerId based on the given followerId
    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }
}
