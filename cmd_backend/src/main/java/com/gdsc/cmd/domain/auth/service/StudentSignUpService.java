package com.gdsc.cmd.domain.auth.service;
import com.gdsc.cmd.domain.user.domain.type.Role;
import lombok.RequiredArgsConstructor;

import com.gdsc.cmd.domain.auth.controller.dto.SignupRequest;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import com.gdsc.cmd.global.security.TokenResponse;

import com.gdsc.cmd.global.security.jwt.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class StudentSignUpService {
    private final UserFacade userFacade;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public TokenResponse execute(SignupRequest request){

        userFacade.checkUserExists(request.getAccountId());




        userRepository.save(

                    User.builder()
                            .accountId(request.getAccountId())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .email(request.getEmail())
                            .phonenumber(request.getPhonenumber())
                            .major(request.getMajor())
                            .classNumber(request.getClassNumber())
                            .birth(request.getBirth())
                            .role(Role.TEACHER)
                            .build()
                    );



        return jwtTokenProvider.createToken(request.getAccountId());

    }
}
