package com.gdsc.cmd.domain.user.service;

import com.gdsc.cmd.domain.user.controller.dto.response.UserSearchResponse;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import com.gdsc.cmd.domain.user.domain.type.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AllUserSearchService {
    private final UserRepository userRepository;

    public List<UserSearchResponse> findAll(){
        return userRepository.findAllByRole(Role.STUDENT).stream().
                map(user -> UserSearchResponse.builder()
                        .accountId(user.getAccountId())
                        .classNumber(user.getClassNumber())
                        .build())
                .collect(Collectors.toList());
    }


}