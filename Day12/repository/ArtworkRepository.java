package com.codeforge.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforge.SpringSecurity.model.Artwork;

 @Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
}

    

