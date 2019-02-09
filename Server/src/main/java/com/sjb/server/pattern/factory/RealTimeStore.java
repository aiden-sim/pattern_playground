package com.sjb.server.pattern.factory;

import com.sjb.server.model.UserInfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 */
public class RealTimeStore extends Product {
    // 다형성 사용
    @Override
    protected void run(String name) {
        String nowDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        realtimeDatabase.computeIfAbsent(nowDt, x -> new ArrayList<>()).add(new UserInfo(name));
    }
}
