package com.gdsc.cmd.domain.auth.service;


import com.gdsc.cmd.domain.auth.domain.RefreshToken;
import com.gdsc.cmd.domain.auth.domain.repository.RefreshTokenRepository;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class LogoutService {
    private final UserFacade userFacade;
    private final RefreshTokenRepository refreshTokenRepository;

    public void execute() {
        Optional<User> user = userFacade.getCurrentUser();

        RefreshToken refreshToken = refreshTokenRepository.findById(user.get().getAccountId())
                .orElseThrow(() -> new RuntimeException("refresh token not found"));

        refreshTokenRepository.delete(refreshToken);
    }

}