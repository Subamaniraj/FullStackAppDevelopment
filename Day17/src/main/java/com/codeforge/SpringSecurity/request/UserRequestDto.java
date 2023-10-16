package com.codeforge.SpringSecurity.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UserRequestDto {
        private Long id;
        private String name;
    } 
