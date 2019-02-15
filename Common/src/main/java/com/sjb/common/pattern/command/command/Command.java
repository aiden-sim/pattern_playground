package com.sjb.common.pattern.command.command;

import com.sjb.common.pattern.command.receiver.CommandType;

import java.io.Serializable;

/**
 * Command 패턴(Command)
 */
public class Command implements Serializable {
	private static final long serialVersionUID = -7687127937206935655L;
	private CommandType commandType;

	public Command(CommandType commandType) {
		this.commandType = commandType;
	}

	public CommandType getCommandType() {
		return commandType.getCommandType();
	}

	@Override
	public String toString() {
		return commandType.getName();
	}
}
