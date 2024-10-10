package com.incluses.inclusesapiredis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.data.redis.core.TimeToLive;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("code-verification-sms")
public class CodeVerification {
    @Id
    @Indexed
    private String code; // Key

    private String value; // Value

    @TimeToLive
    private Long expiration; // Tempo de expiração em segundos

    public CodeVerification(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
