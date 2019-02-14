package com.sjb.server.pattern.memento;

/**
 * Originator (내부 객체상태)
 */

import java.time.LocalDateTime;

public class Originator {
    private LocalDateTime localDateTime;
    private String ip;

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Memento saveToMemento() {
        return new Memento(localDateTime, ip);
    }

    public void getFromMemento(Memento memento) {
        localDateTime = memento.getLocalDateTime();
        ip = memento.getIp();
    }

    public String getState() {
        return localDateTime.toString() + "_" + ip.toString();
    }
}
