package com.gdsc.cmd.domain.user.controller;


import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.service.ViewAllStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final ViewAllStudentService viewAllStudentService;
    @GetMapping("/show/all/user")
    public List<User> showAllUser(){
        return viewAllStudentService.excute();
    }
}
