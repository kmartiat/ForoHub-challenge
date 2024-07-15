package com.one.challenge.foroHub.controller;

import com.one.challenge.foroHub.dto.request.RequestLoginUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    private ResponseEntity login(@RequestBody @Valid RequestLoginUserDto userDto) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.email(), userDto.password()));
        return ResponseEntity.ok(null);
    }
}
