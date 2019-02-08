package com.sjb.server.pattern.adapter;

import com.sjb.common.model.CommandType;

/**
 * Adapter (위임)
 */
public class PrintCommand implements Print {
    private Log log;

    public PrintCommand(CommandType commandType) {
        this.log = new Log(commandType.getName());
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
