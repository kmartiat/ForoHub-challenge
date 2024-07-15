package com.one.challenge.foroHub.controller;

import com.one.challenge.foroHub.dto.request.RequestLoginUserDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class AuthController {

    @PostMapping
    private ResponseEntity login(@RequestBody @Valid RequestLoginUserDto userDto) {
        return ResponseEntity.ok(null);
    }
}
