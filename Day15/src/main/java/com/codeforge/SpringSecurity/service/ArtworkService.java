package com.codeforge.SpringSecurity.service;

import java.util.List;

import com.codeforge.SpringSecurity.request.ArtworkRequestDto;

import com.codeforge.SpringSecurity.response.ArtworkResponseDto;




public interface ArtworkService {

    boolean saveArtwork(ArtworkRequestDto artworkRequest);

    List<ArtworkResponseDto> getAllArtworks();

    boolean updateArtwork(String artworkId, ArtworkRequestDto artworkRequest);

    boolean deleteArtwork(String artworkId);
    
}
