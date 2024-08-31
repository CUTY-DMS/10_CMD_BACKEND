package com.gdsc.cmd.global.findpassword.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SendMailService {
    private final RedisService redisService;


    @Value("${spring.mail.username}")
    private String formEmail;

    //@Value("${props.reset-password-url}")
    private String resetPwUrl;

    private final JavaMailSender mailSender;






}
