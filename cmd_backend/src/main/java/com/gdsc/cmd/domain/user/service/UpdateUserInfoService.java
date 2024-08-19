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
public class UpdateUserInfoService { // put사용
    private final UserRepository userRepository;
    private final UserFacade userFacade;
    @Transactional
    public void userInfoUpdate(String accountId, UserDetailRequest userDetailRequest){
        User user = userRepository.findByAccountId(accountId).orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        // 기존 값들을 유지하고, null이 아닌 경우에만 업데이트
        User.UserBuilder userBuilder = User.builder()
                .id(user.getId())
                .accountId(user.getAccountId())
                .password(user.getPassword())
                .role(user.getRole())
                .phonenumber(userDetailRequest.getPhonenumber())
                .birth(userDetailRequest.getBirth())
                .major(userDetailRequest.getMajor())
                .email(userDetailRequest.getEmail())
                .classNumber(userDetailRequest.getClassNumber());

        userRepository.save(userBuilder.build());
    }
}
