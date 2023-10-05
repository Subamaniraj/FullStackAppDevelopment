package com.codeforge.SpringSecurity.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDto {
    private String projectId;
    private String projectName;
    private String description;
    private String projectType;
    private String privacy;
    private List<String> members;
    private List<String> goals;
}

