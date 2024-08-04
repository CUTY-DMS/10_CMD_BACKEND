package com.gdsc.cmd.domain.auth.domain;


import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@RedisHash
public class RefreshToken {
    @Id
    private String accountId;

    private String refreshToken;

    private Long expiration;

    public RefreshToken updateExpiration(Long expiration){
        this.expiration = expiration;
        return this;
    }
}
