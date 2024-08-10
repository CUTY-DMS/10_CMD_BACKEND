package com.gdsc.cmd.domain.user.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@RequiredArgsConstructor
@Getter
public class UserDetailResponse {


    private String accountId;

    private Long phonenumber;

    private String major;

    private String email;

    private int classNumber;

    private int birth;

    @Builder
    public UserDetailResponse(String accountId, Long phonenumber, String major, String email, int classNumber, int birth) {
        this.accountId = accountId;
        this.phonenumber = phonenumber;
        this.major = major;
        this.email = email;
        this.classNumber = classNumber;
        this.birth = birth;
    }
}
