package com.sjb.server.pattern.decorator;

/**
 * ConcreteComponent
 */
public class RealUserName implements UserName {
    private String name;

    public RealUserName(String name) {
        this.name = name;
    }

    @Override
    public String getUserName() {
        return name;
    }
}
