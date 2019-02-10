package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.bridge.implementor.Computer;

/**
 * Bridge 패턴
 * Abstraction(추상화)의 역할
 * 기능 클래스
 */
public abstract class Programmer {
    protected final Computer computer;

    public Programmer(Computer computer) {
        this.computer = computer;
    }

    public abstract void useOs();
}