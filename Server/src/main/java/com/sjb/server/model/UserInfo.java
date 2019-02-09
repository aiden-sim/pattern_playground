package com.sjb.server.model;


import java.time.LocalDateTime;

public class UserInfo {
    private final String name;
    private final LocalDateTime createDt;

    public UserInfo(String name) {
        this.name = name;
        this.createDt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return name + "_" + createDt;
    }
}
