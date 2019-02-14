package com.sjb.server.pattern.observer;

import com.sjb.server.model.UserInfo;

import java.util.List;

/**
 * ConcreteSubject(구체적인 관찰 대상자)
 */
public class ConcreteSubject extends Subject {
    private List<UserInfo> userInfos;

    public ConcreteSubject(List<UserInfo> userInfos) {
        this.userInfos = userInfos;
    }

    public List<UserInfo> getUserInfos() {
        return userInfos;
    }

    public void execute() {
        notifiyObservers();
    }
}
