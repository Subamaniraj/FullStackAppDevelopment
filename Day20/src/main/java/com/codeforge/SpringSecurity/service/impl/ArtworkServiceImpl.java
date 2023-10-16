package com.codeforge.SpringSecurity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeforge.SpringSecurity.model.Artwork;

import com.codeforge.SpringSecurity.repository.ArtworkRepository;

import com.codeforge.SpringSecurity.request.ArtworkRequestDto;

import com.codeforge.SpringSecurity.response.ArtworkResponseDto;

import com.codeforge.SpringSecurity.service.ArtworkService;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@Transactional
@RequiredArgsConstructor
public class ArtworkServiceImpl implements ArtworkService {

    private final ArtworkRepository artworkRepository;

    @Override
    public boolean saveArtwork(ArtworkRequestDto artworkRequest) {
        Optional<Artwork> isartworkOptional=artworkRepository.existsByTitle(artworkRequest.getTitle());
		if(isartworkOptional.isPresent()){
			var artwork=Artwork.builder()
                    .userId(artworkRequest.getUserId())
					.title(artworkRequest.getTitle())
					.description(artworkRequest.getDescription())
					.file(artworkRequest.getFile())
					.build();
			artworkRepository.save(artwork);
			return true;
		}
		else{
			return false;
		}
    }

    @Override
    public List<ArtworkResponseDto> getAllArtworks() {
        List<Artwork> artworkList = artworkRepository.findAll();
		List<ArtworkResponseDto> artworkResponseList = new ArrayList<>();
	
		for (Artwork artwork : artworkList) {
			ArtworkResponseDto artworkResponse = new ArtworkResponseDto(); 
			artworkResponse.setTitle(artwork.getTitle());
			artworkResponse.setDescription(artwork.getDescription());
			artworkResponse.setFile(artwork.getFile());
		
	
			artworkResponseList.add(artworkResponse);
		}
	
		return artworkResponseList;
    }
    @Override
    public List<ArtworkResponseDto> getUserArtworks(String userId) {
        List<Artwork> userArtworkList = artworkRepository.findByUserId(userId);
        List<ArtworkResponseDto> userArtworkResponseList = new ArrayList<>();
        for (Artwork artwork : userArtworkList) {
            ArtworkResponseDto artworkResponse = new ArtworkResponseDto();
            artworkResponse.setTitle(artwork.getTitle());
            artworkResponse.setDescription(artwork.getDescription());
            artworkResponse.setFile(artwork.getFile());
            userArtworkResponseList.add(artworkResponse);
        }
        return userArtworkResponseList;
    }

    @Override
    public boolean updateArtwork(String artworkId, ArtworkRequestDto artworkRequest) {
        Optional<Artwork> optionalartwork = artworkRepository.findById(artworkId);
        if (optionalartwork.isPresent()) {
            Artwork artwork = optionalartwork.get();
           artwork.setTitle(artworkRequest.getTitle());
            artwork.setDescription(artworkRequest.getDescription());
            artwork.setFile(artworkRequest.getFile());
            artworkRepository.save(artwork);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteArtwork(String artworkId) {
        Optional<Artwork> optionalartwork = artworkRepository.findById(artworkId);
        if (optionalartwork.isPresent()) {
           artworkRepository.deleteById(artworkId);
            return true;
        } else {
            return false;
        }
    }

}
