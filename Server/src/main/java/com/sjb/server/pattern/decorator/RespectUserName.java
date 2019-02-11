package com.sjb.server.pattern.decorator;

/**
 * ConcreateDecorator
 */
public class RespectUserName extends Decorator {

    public RespectUserName(UserName userName) {
        super(userName);
    }

    @Override
    public String getUserName() {
        return userName.getUserName() + "님";
    }
}
