package com.codeforge.SpringSecurity.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ProjectRequestDto {
    private String projectName;
    private String description;
    private String projectType; 
    private String privacy;
    private List<String> members;
    private List<String> goals;
}

