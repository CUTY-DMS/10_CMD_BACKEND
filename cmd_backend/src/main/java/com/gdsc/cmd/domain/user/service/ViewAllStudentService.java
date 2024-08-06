package com.gdsc.cmd.domain.user.service;

import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ViewAllStudentService {
    private final UserRepository userRepository;

    public List<User> excute(){
        List<User> users = userRepository.findAll();

        for(int i = 0;i<users.size();i++){

        }
        return userRepository.findAll();
    }
}
