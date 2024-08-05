package com.gdsc.cmd.domain.user.service;

import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ViewAllStudentService {
    private final UserRepository userRepository;

    public List<User> excute(){

        return userRepository.findAll();
    }
}
