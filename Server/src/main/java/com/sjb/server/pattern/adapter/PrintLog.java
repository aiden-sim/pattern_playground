package com.sjb.server.pattern.adapter;

/**
 * Adapter 패턴
 * Adapter (위임)
 */
public class PrintLog<T> implements Print {
    private Log log;

    public static <T> PrintLog newInstance(T t) {
        return new PrintLog(t);
    }

    private PrintLog(T t) {
        this.log = new Log(t);
    }

    @Override
    public void printWithLogger() {
        log.printWithLogger();
    }

    @Override
    public void printWithSout() {
        log.printWithSout();
    }
}
