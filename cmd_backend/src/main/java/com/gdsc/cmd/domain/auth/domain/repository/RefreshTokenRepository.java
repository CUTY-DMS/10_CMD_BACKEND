package com.gdsc.cmd.domain.auth.domain.repository;

import com.gdsc.cmd.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken,String> {
    Optional<RefreshToken> findByRefreshToken(String token);
}
