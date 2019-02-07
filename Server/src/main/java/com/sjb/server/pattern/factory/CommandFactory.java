package com.sjb.server.pattern.factory;

import com.sjb.common.model.CommandType;

/**
 * ConcreteCreator(구체적인 작성자)
 */
public class CommandFactory extends Factory {
	private static CommandFactory instance = null;

	private CommandFactory() {
	}

	public static synchronized CommandFactory getInstance() {
		if (instance == null) {
			instance = new CommandFactory();
		}
		return instance;
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
