package com.sjb.server.model;


import java.time.LocalDateTime;

/**
 * Prototype 패턴 (Cloneable)
 */
public class UserInfo implements Cloneable {
    private String name;
    private LocalDateTime createDt;

    public UserInfo(String name) {
        this.name = name;
        this.createDt = LocalDateTime.now();
    }

    /**
     * Setter 메서드를 선호하지 않지만 (불변을 해치기 때문에)
     * Prototype 패턴 테스트를 위해 공개해둠
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCreateDt(LocalDateTime createDt) {
        this.createDt = createDt;
    }

    public LocalDateTime getCreateDt() {
        return createDt;
    }

    @Override
    public String toString() {
        return name + "_" + createDt;
    }

    /**
     * Prototype 패턴을 사용하기 위한 clone 메서드 구현
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
