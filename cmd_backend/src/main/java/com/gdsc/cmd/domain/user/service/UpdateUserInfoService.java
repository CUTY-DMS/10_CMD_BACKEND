package com.gdsc.cmd.domain.user.service;

import com.gdsc.cmd.domain.user.controller.dto.request.UserDetailRequest;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import com.gdsc.cmd.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@RequiredArgsConstructor
@Service
@Transactional
public class UpdateUserInfoService { // put사용
    private final UserRepository userRepository;
    private final UserFacade userFacade;

    public void userInfoUpdate(String accountId, UserDetailRequest userDetailRequest) {
        User user = userRepository.findByAccountId(accountId).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        // toBuilder를 사용하여 기존 필드 유지, 필요한 필드만 업데이트
        User updatedUser = user.toBuilder()
                .phonenumber(Objects.nonNull(userDetailRequest.getPhonenumber()) ? userDetailRequest.getPhonenumber() : user.getPhonenumber())
                .birth(Objects.nonNull(userDetailRequest.getBirth()) ? userDetailRequest.getBirth() : user.getBirth())
                .major(Objects.nonNull(userDetailRequest.getMajor()) ? userDetailRequest.getMajor() : user.getMajor())
                .email(Objects.nonNull(userDetailRequest.getEmail()) ? userDetailRequest.getEmail() : user.getEmail())
                .classNumber(Objects.nonNull(userDetailRequest.getClassNumber()) ? userDetailRequest.getClassNumber() : user.getClassNumber())
                .build();

        userRepository.save(updatedUser);
    }
}
