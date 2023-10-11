package com.codeforge.SpringSecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeforge.SpringSecurity.model.Project;

public interface ProjectRepository extends JpaRepository<Project,String>{

    Optional<Project> existsByProjectName(String projectName);
    
}
