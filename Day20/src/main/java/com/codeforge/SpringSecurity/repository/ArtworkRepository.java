package com.codeforge.SpringSecurity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforge.SpringSecurity.model.Artwork;

 @Repository
public interface ArtworkRepository extends JpaRepository<Artwork, String> {

    Optional<Artwork> findById(String  artworkid);

    Optional<Artwork> existsByTitle(String title);

    void deleteById(String artworkId);

    List<Artwork> findByUserId(String userId);
}

    

