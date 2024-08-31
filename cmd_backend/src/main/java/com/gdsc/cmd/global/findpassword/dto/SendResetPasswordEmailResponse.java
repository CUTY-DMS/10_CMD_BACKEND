package com.gdsc.cmd.global.findpassword.dto;

import lombok.Builder;

public class SendResetPasswordEmailRes {
    private String UUID;

    @Builder
    public SendResetPasswordEmailRes(String UUID) {
        this.UUID = UUID;
    }
}
