package com.gdsc.cmd.domain.auth.controller.dto;


import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class SigninRequest {
    @NotBlank
    private String accountId;
    @NotBlank
    private String password;
    @NotBlank
    private String deviceToken;
}
