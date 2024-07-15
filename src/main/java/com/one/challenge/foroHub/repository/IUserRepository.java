package com.one.challenge.foroHub.repository;

import com.one.challenge.foroHub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String username);
}
