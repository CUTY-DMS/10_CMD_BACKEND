package com.gdsc.cmd.global.findpassword.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@RequiredArgsConstructor
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate;

    @Transactional
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 유효시간 설정하고 유효시간 지나면 자동 삭제
    @Transactional
    public void setValueswithTimeout(String key,String value, long timeout) {
        redisTemplate.opsForValue().set(key,value,timeout, TimeUnit.MICROSECONDS);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Transactional
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }
}