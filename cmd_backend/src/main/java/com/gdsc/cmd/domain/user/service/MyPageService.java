package com.gdsc.cmd.domain.user.service;

import com.gdsc.cmd.domain.user.controller.dto.response.UserDetailResponse;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MyPageService {

    private final UserFacade userFacade;

    public UserDetailResponse myInfo() {

        Optional<User> currentUser = userFacade.getCurrentUser();

        return UserDetailResponse.builder()
                .accountId(currentUser.get().getAccountId())
                .major(currentUser.get().getMajor())
                .email(currentUser.get().getEmail())
                .birth(currentUser.get().getBirth())
                .phonenumber(currentUser.get().getPhonenumber())
                .classNumber(currentUser.get().getClassNumber())
                .build();

    }
}
