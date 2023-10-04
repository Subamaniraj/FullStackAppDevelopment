package com.codeforge.SpringSecurity.auth;

import com.codeforge.SpringSecurity.model.User;
import com.codeforge.SpringSecurity.model.enumerated.Role;
import com.codeforge.SpringSecurity.repository.UserRepository;
import com.codeforge.SpringSecurity.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .name(request.getName())
        .email(request.getEmail())
        .pwd(passwordEncoder.encode(request.getPwd()))
        .role(Role.ARTIST)
        .build();
        repository.save(user);
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getName(),
            request.getPassword()
        )
    );
    var user = repository.findByName(request.getName())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken)
        .build();
  }

  
}