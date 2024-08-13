package com.gdsc.cmd.domain.user.service;

import com.gdsc.cmd.domain.user.controller.dto.response.UserDetailResponse;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService {
    private final UserRepository userRepository;

    public Optional<UserDetailResponse> findUserDetail(String accountId){
        return userRepository.findByAccountId(accountId).flatMap(
                user -> Optional.ofNullable(UserDetailResponse.builder()
                        .accountId(user.getAccountId())
                        .classNumber(user.getClassNumber())
                        .birth(user.getBirth())
                        .major(user.getMajor())
                        .email(user.getEmail())
                        .phonenumber(user.getPhonenumber())
                        .build()));
    }

}
