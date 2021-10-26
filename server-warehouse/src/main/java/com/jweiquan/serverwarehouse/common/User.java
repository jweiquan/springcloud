package com.jweiquan.serverwarehouse.common;

import lombok.Getter;

@Getter
public class User {
    private final Integer brandUserId;

    public User() {
        this.brandUserId = 8;
    }
}
