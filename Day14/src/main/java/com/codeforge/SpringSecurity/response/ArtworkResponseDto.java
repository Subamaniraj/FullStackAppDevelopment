package com.codeforge.SpringSecurity.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtworkResponseDto {
    private String title;
    private String file;
    
}
