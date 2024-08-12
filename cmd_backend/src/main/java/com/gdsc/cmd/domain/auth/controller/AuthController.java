package com.gdsc.cmd.domain.auth.controller;

import antlr.Token;
import com.gdsc.cmd.domain.auth.controller.dto.SigninRequest;
import com.gdsc.cmd.domain.auth.controller.dto.SignupRequest;
import com.gdsc.cmd.domain.auth.service.LoginService;
import com.gdsc.cmd.domain.auth.service.ReissueService;
import com.gdsc.cmd.domain.auth.service.StudentSignUpService;
import com.gdsc.cmd.domain.auth.service.TeacherSignUpService;
import com.gdsc.cmd.global.security.TokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final LoginService signInService;
    private final StudentSignUpService studentSignUpService;
    private final ReissueService reissueService;
    private final TeacherSignUpService teacherSignUpService;

    @PostMapping("/signin") // 로그인
    public TokenResponse signIn(SigninRequest request){
        return signInService.execute(request);

    }
    @PostMapping("/signup")
    public TokenResponse signup(@RequestBody SignupRequest signupRequest) {

        return studentSignUpService.execute(signupRequest);
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "AUTHORIZATION_HEADER") String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

    @PostMapping("/signup/admin")
    public TokenResponse adminSignup(@RequestBody SignupRequest signupRequest) {
        return teacherSignUpService.execute(signupRequest);
    }
}
