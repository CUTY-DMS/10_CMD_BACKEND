package com.gdsc.cmd.global.findpassword.service;

import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ExistsEmailService {
    private final UserRepository userRepository;

    public void checkUserByEmail(String email){
        boolean exists = userRepository.existsByEmail(email);
        if(exists == false){
            throw new RuntimeException("Email not found");
        }
    }
}
