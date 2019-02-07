package com.sjb.server.pattern.factory;

import com.sjb.common.model.CommandType;

/**
 * ConcreteCreator(구체적인 작성자)
 */
public class CommandFactory extends Factory {
    private static final CommandFactory INSTANCE = new CommandFactory();

    private CommandFactory() {
        if (INSTANCE != null) {
            throw new RuntimeException("중복 생성");
        }
    }

    /**
     * Singleton 패턴
     * 객체에 상태가 없어야 한다. Factory는 Singleton 패턴으로 설계되는 경우가 많다.
     */
    public static CommandFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Product create(CommandType commandType) {
        switch (commandType) {
            case ANALYSIS:
                return new Analysis();
            case REALTIME:
                return new RealTime();
            default:
                return null;
        }
    }
}
