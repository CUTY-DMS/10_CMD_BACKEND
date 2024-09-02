package com.gdsc.cmd.global.findpassword.dto;

import lombok.Builder;

public class SendResetPasswordEmailResponse {
    private String UUID;

    @Builder
    public SendResetPasswordEmailResponse(String UUID) {
        this.UUID = UUID;
    }
}
