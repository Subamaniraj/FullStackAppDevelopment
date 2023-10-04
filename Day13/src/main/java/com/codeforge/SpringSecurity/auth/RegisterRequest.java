package com.codeforge.SpringSecurity.auth;

import com.codeforge.SpringSecurity.model.enumerated.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  private String name;
  private String email;
  private String pwd;
}