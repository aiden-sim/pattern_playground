package com.sjb.server.pattern.decorator;

/**
 * Decorator
 */
public abstract class Decorator implements UserName {
    protected UserName userName;

    public Decorator(UserName userName) {
        this.userName = userName;
    }
}
