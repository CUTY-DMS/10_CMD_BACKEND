package com.gdsc.cmd.domain.user.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@AllArgsConstructor
@Builder
public class UserDetailResponse {


    private String accountId;

    private String phonenumber;

    private String major;

    private String email;

    private String classNumber;

    private String birth;


}
