package com.smarttechnologies.servicesqatar.Controller;

import com.smarttechnologies.servicesqatar.Services.AuthService;
import com.smarttechnologies.servicesqatar.Services.CommentService;
import com.smarttechnologies.servicesqatar.Services.RefreshTokenService;
import com.smarttechnologies.servicesqatar.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

public class AuthResource {


    @RestController
    @AllArgsConstructor
    @RequestMapping("/api/auth")
    public class PostResource {



        private final AuthService authService;
        private final RefreshTokenService refreshTokenService;

        @PostMapping
        public ResponseEntity<Void> createComment(@RequestBody CommentsDto CommentsDto) {
            CommentService.save(CommentsDto);
            return new ResponseEntity<>(CREATED);
        }
        @PostMapping("/signup")
        public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
            authService.signup(registerRequest);
            return new ResponseEntity<>("User Registration Successful",
                    OK);
        }

        @GetMapping("accountVerification/{token}")
        public ResponseEntity<String> verifyAccount(@PathVariable String token) {
            authService.verifyAccount(token);
            return new ResponseEntity<>("Account Activated Successfully", OK);
        }

        @PostMapping("/login")
        public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
            return authService.login(new LoginRequest());
        }

        @PostMapping("/refresh/token")
        public AuthenticationResponse refreshTokens( @RequestBody RefreshTokenRequest refreshTokenRequest) {
            return authService.refreshToken(refreshTokenRequest);
        }

        @PostMapping("/logout")
        public ResponseEntity<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest) {
            refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
            return ResponseEntity.status(OK).body("Refresh Token Deleted Successfully!!");
        }
}}
