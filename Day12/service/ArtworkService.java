package com.codeforge.SpringSecurity.service;
import java.util.List;

import com.codeforge.SpringSecurity.request.ArtworkRequestDto;
import com.codeforge.SpringSecurity.response.ArtworkResponseDto;



public interface ArtworkService {

    boolean saveArtwork(ArtworkRequestDto ArtworkRequest);

    List<ArtworkResponseDto> getAllArtworks();

    boolean updateArtwork(String ArtworkId, ArtworkRequestDto ArtworkRequest);

    boolean deleteArtwork(String ArtworkId);
    
}
