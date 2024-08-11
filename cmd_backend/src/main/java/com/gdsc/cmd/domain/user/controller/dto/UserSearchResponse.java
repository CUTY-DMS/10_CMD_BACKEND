package com.gdsc.cmd.domain.user.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSearchResponse {

    private String accountId;

    private int classNumber;

    @Builder
    public UserSearchResponse(String accountId, int classNumber) {
        this.accountId = accountId;
        this.classNumber = classNumber;
    }
}
