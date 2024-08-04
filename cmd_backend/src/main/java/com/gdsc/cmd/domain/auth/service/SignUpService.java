package com.gdsc.cmd.domain.auth.service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.gdsc.cmd.domain.auth.controller.dto.SignupRequest;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import com.gdsc.cmd.global.security.TokenResponse;

import com.gdsc.cmd.global.security.jwt.JwtTokenProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    public TokenResponse execute(SignupRequest signUpDto){
        userFacade.checkUserExists(signUpDto.getAccountId());


        String password = passwordEncoder.encode(signUpDto.getPassword());

        userRepository.save(
                User.builder()
                        .accountId(signUpDto.getAccountId())
                        .password(password)
                        .build()
        );

        return jwtTokenProvider.createToken(signUpDto.getAccountId());

    }
}
