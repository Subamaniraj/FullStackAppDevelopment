package com.codeforge.SpringSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name="_artwork")
public class Artwork {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String artworkid;
    private String title;
    private String description;
    private String file;
    public Artwork(String artworkid, String title, String description, String file) {
        this.artworkid = artworkid;
        this.title = title;
        this.description = description;
        this.file = file;
    }
    public Artwork() {
    }
    
    
}
