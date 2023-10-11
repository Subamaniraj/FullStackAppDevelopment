package com.codeforge.SpringSecurity.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArtworkRequestDto {
    private String title;
    private String description;
    private String file;
    
}
