package com.gdsc.cmd.domain.auth.controller;

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
    public String signup(@RequestBody SignupRequest signupRequest) {
        studentSignUpService.execute(signupRequest);

        return "Student signed up successfully";
    }

    @PostMapping("/reissue")
    public TokenResponse reissue(@RequestHeader(name = "AUTHORIZATION_HEADER") String refreshToken) {
        return reissueService.reissue(refreshToken);
    }

    @PostMapping("/signup/admin")
    public String adminSignup(@RequestBody SignupRequest signupRequest) {
        teacherSignUpService.execute(signupRequest);

        return "Teacher signed up successfully";
    }
}
