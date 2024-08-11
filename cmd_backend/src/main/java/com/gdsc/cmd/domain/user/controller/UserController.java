package com.gdsc.cmd.domain.user.controller;


import com.gdsc.cmd.domain.user.controller.dto.UserDetailResponse;
import com.gdsc.cmd.domain.user.controller.dto.UserSearchResponse;
import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.service.AllUserSearchService;
import com.gdsc.cmd.domain.user.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AllUserSearchService allUserSearchService;
    private final UserDetailService userDetailService;
    @GetMapping("")
    public List<UserSearchResponse> showAllUser(){
        return allUserSearchService.findAll();
    }

    @GetMapping("/{account-id}")
    public Optional<UserDetailResponse> searchUserDetail(@PathVariable String accountId){
        return userDetailService.findUserDetail(accountId);
    }
}
