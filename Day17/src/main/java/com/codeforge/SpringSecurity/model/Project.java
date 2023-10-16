package com.codeforge.SpringSecurity.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Entity
@Table(name="_projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectId;
    private String projectName;
    private String description;
    private String projectType;
    private String privacy;
    private List<String> members;
    private List<String> goals;
    
    public Project() {
    }

    public Project(String projectId, String projectName, String description, String projectType, String privacy,
            List<String> members, List<String> goals) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.projectType = projectType;
        this.privacy = privacy;
        this.members = members;
        this.goals = goals;
    }

    
}
