package com.gdsc.cmd.domain.user.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserSearchResponse {

    private String accountId;

    private String classNumber;


}
