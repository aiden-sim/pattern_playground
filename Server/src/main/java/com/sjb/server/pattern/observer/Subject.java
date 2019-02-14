package com.sjb.server.pattern.observer;

import com.sjb.server.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject(관찰 대상자)의 역할
 */
public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    // Observer 추가
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer 제거
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    // 통지
    public void notifiyObservers() {
        observers.forEach(observer -> {
            observer.update(this);
        });
    }

    public abstract List<UserInfo> getUserInfos();

    public abstract void execute();
}
