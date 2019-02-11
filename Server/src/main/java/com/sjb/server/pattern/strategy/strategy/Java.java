package com.sjb.server.pattern.strategy.strategy;

/**
 * ConcreteStrategy(구체적인 전략)의 역할
 */
public class Java implements ProgramSkill {
	@Override public String getSkill() {
		return "java";
	}
}
