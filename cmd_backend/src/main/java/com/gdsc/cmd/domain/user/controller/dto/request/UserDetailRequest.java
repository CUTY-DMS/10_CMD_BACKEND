package com.gdsc.cmd.domain.user.controller.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class UserDetailRequest {
    // 변경 할 수 있는거 : phonenumber, major, email, classNumber, birth

    @NotNull
    private String phonenumber;

    @NotNull
    private String major;

    @NotNull
    private String email;

    @NotNull
    private String classNumber;

    @NotNull
    private String birth;

}
