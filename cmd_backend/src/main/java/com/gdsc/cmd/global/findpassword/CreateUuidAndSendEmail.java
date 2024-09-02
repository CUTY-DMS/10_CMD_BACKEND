package com.gdsc.cmd.global.findpassword;
/*
import com.gdsc.cmd.global.findpassword.dto.SendResetPasswordEmailRequest;
import com.gdsc.cmd.global.findpassword.dto.SendResetPasswordEmailResponse;
import com.gdsc.cmd.global.findpassword.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
public class CreateUuidAndSendEmail {
    private final UserService userService;


   @Operation(summary = "UUID 생성")//클라한테 이게 무슨 api인지 알려줌.
    @PostMapping("send-reset-password")
    public SendResetPasswordEmailResponse sendResetPassword(
            @Validated @RequestBody SendResetPasswordEmailRequest resetPasswordEmailReqest) {
            userService.checkUserbyEmail(resetPasswordEmailReqest.getEmail());

    }
    )

}
