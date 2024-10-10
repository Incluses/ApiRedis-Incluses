package com.incluses.inclusesapiredis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash("admin-account")
public class AdminAccount {

    @Id
    private String id;
    @Indexed
    private String email;
    private String password;

    public AdminAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
