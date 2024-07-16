package com.one.challenge.foroHub.service;

import com.one.challenge.foroHub.domain.User;

public interface TokenService {
    String generateToken(User user);

    String getSubject(String token);
}
