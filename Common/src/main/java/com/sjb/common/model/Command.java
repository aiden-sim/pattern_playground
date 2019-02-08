package com.sjb.common.model;

import java.io.Serializable;

public class Command implements Serializable {
    private static final long serialVersionUID = -7687127937206935655L;
    private CommandType commandType;

    public Command(CommandType commandType) {
        this.commandType = commandType;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    @Override
    public String toString() {
        return commandType.getName();
    }
}
