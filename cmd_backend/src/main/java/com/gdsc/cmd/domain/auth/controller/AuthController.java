package com.gdsc.cmd.domain.auth.controller;

import com.gdsc.cmd.domain.auth.controller.dto.SigninRequest;
import com.gdsc.cmd.domain.auth.controller.dto.SignupRequest;
import com.gdsc.cmd.domain.auth.service.SignInService;
import com.gdsc.cmd.domain.auth.service.SignUpService;
import com.gdsc.cmd.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignInService signInService;
    private final SignUpService signUpService;
    @PostMapping("/signin") // 로그인
    public TokenResponse signIn(SigninRequest request){
        return signInService.execute(request);

    }
    @PostMapping("/signup") // 회원 가입
    public TokenResponse signUp(SignupRequest request){
        return signUpService.execute(request);
    }

}
