package com.sjb.server.pattern.memento;

import java.time.LocalDateTime;

/**
 * Memento (현재정보)
 */
public class Memento {
    private LocalDateTime localDateTime;
    private String ip;

    public Memento(LocalDateTime localDateTime, String ip) {
        this.localDateTime = localDateTime;
        this.ip = ip;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public String getIp() {
        return ip;
    }
}
