package com.gdsc.cmd.domain.auth.controller;

import com.gdsc.cmd.domain.auth.controller.dto.SigninRequest;
import com.gdsc.cmd.domain.auth.controller.dto.SignupRequest;
import com.gdsc.cmd.domain.auth.service.SignInService;
import com.gdsc.cmd.domain.auth.service.SignUpService;
import com.gdsc.cmd.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest signupRequest) {
        signUpService.execute(signupRequest);

        return "User signed up successfully";
    }

}
