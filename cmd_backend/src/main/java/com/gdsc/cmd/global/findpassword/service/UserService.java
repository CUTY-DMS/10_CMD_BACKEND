package com.gdsc.cmd.global.findpassword.service;

import com.gdsc.cmd.domain.user.domain.User;
import com.gdsc.cmd.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RedisService redisService;
    private final SendMailService sendMailService;

    @Transactional
    public void resetPassword(String uuid, String password) {
/*
       // String email = redisService.getValue(uuid);
        if (email == null) {
            throw new RuntimeException();
        }

        public void updatePassword(String email,String newPassword){
            User user = userRepository.findByEmail(email)
                    .orElseThrow(()->new RuntimeException("User not found"));

            String hadhedPassword = passwordEncoder.encode(newPassword);
        }
*/





    }
}
