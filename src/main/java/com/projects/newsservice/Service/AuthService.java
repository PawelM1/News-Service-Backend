package com.projects.newsservice.Service;

import com.projects.newsservice.config.JwtUtilities;
import com.projects.newsservice.dto.LoginCredentials;
import com.projects.newsservice.dto.LoginResponse;
import com.projects.newsservice.dto.UserDto;
import com.projects.newsservice.entity.User;
import com.projects.newsservice.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {
    private PasswordEncoder passwordEncoder;
    private final UserRepo userRepository;
    private final AuthenticationManager authenticationManager;
    private JwtUtilities jwtUtilities;

    public AuthService(PasswordEncoder passwordEncoder, UserRepo userRepository, AuthenticationManager authenticationManager,
                       JwtUtilities jwtUtilities) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtilities = jwtUtilities;
    }

    public ResponseEntity<String> register(UserDto userDTO) {
        if (userRepository.existsByUsername(userDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error:This user already exists");
        }

        if (userRepository.existsByEmail(userDTO.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: This E-mail already exists");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setEmail(userDTO.getEmail());
        user.setRole("ROLE_USER");
        userRepository.save(user);

        return ResponseEntity.ok("Successful registration");
    }

    public ResponseEntity<LoginResponse> login(LoginCredentials loginCredentials) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginCredentials.getUsername(), loginCredentials.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String jwt = jwtUtilities.generateJwtToken(authenticate);
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticate.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

}
