package com.codeforge.SpringSecurity.service;

import java.util.List;

import com.codeforge.SpringSecurity.request.ProjectRequestDto;
import com.codeforge.SpringSecurity.response.ProjectResponseDto;



public interface ProjectService {

    boolean saveProject(ProjectRequestDto projectRequest);

    List<ProjectResponseDto> getAllProjects();

    boolean updateProject(String projectId, ProjectRequestDto projectRequest);

    boolean deleteProject(String projectId);
    
}
