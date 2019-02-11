package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.strategy.strategy.ObjectC;

/**
 * Bridge 패턴
 * RefinedAbstraction(개선된 추상화)의 역할
 * <p>
 * Strategy 패턴 (Context)
 */
public class MobileProgrammer extends Programmer {
	public MobileProgrammer(Computer computer, String name) {
		super(computer, name + " is mobile programmer");
		this.skill = new ObjectC();
	}

	@Override
	public void useOs() {
		computer.useOs();
	}
}
