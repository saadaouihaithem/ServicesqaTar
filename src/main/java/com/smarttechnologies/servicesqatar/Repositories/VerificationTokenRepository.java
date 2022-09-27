package com.smarttechnologies.servicesqatar.Repositories;


import com.smarttechnologies.servicesqatar.Entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
    public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    // find by the token
        Optional<VerificationToken> findByToken(String token);
    }

