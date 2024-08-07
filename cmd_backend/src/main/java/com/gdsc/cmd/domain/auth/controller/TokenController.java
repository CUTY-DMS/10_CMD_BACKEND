package com.gdsc.cmd.domain.auth.controller;


import java.time.Instant;

import com.gdsc.cmd.domain.auth.controller.dto.RefreshTokenResponse;
import com.gdsc.cmd.global.security.jwt.JwtReissueUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TokenController {
    private final JwtReissueUtil jwtUtil;

    @GetMapping("/refresh/{id}")
    public ResponseEntity<RefreshTokenResponse> getRefresh(@PathVariable("id") Long id) {
        String refreshToken = jwtUtil.;
        RefreshTokenResponse response = new RefreshTokenResponse(refreshToken);
        return ResponseEntity.ok(response);
    }
}