package com.sjb.server.pattern.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Adaptee (개조되는 쪽)
 * 제공되고 있는 쪽
 * 이 Class는 기존에 사용되고 있는 라이브러리 역할이고 변경할 수 없다.
 * <p>
 * ex) slf4j 도 다른 로깅 시스템의 adapter, facade 역할을 한다.
 */
public class Log {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private String log;

    public Log(String log) {
        this.log = log;
    }

    public void printWithLogger() {
        logger.info("{}", log);
    }

    public void printWithSout() {
        System.out.println(log);
    }
}
