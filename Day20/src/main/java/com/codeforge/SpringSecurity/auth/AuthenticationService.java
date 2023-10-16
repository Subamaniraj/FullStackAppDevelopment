package com.codeforge.SpringSecurity.auth;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codeforge.SpringSecurity.config.JwtService;
import com.codeforge.SpringSecurity.model.User;
import com.codeforge.SpringSecurity.model.enumerated.Role;
import com.codeforge.SpringSecurity.repository.UserRepository;

import lombok.RequiredArgsConstructor;

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

        return AuthenticationResponse.builder()
        .token(jwtToken)

        .build();
    }
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getName(),
                request.getPwd()
            )
        );
        var user = repository.findByName(request.getName()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).id(user.getId()).name(user.getName()).build();
    }
    
}
