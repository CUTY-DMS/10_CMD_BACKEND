package com.gdsc.cmd.global.findpassword;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class CreateUuidAndSendEmail {
    @Operation(summary = "UUID 생성")//클라한테 이게 무슨 api인지 알려줌.
    @PostMapping("send-reset-password")
    public SendResetPasswordEmailRes sendResetPassword(
            @Validated @RequestBody SendResetPasswordEmailReq resetPasswordEmailReq) {
        Use

    }
    )

}
