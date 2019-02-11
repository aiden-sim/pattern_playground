package com.sjb.server.pattern.strategy.strategy;

/**
 * ConcreteStrategy(구체적인 전략)의 역할
 */
public class ObjectC implements ProgramSkill {
	// 구체적인 알고리즘
	@Override public String getSkill() {
		return "objectC";
	}
}
