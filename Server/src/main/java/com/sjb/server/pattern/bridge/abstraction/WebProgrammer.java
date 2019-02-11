package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.strategy.strategy.Html;

/**
 * Bridge 패턴
 * RefinedAbstraction(개선된 추상화)의 역할
 * <p>
 * Strategy 패턴 (Context)
 */
public class WebProgrammer extends Programmer {
	public WebProgrammer(Computer computer, String name) {
		super(computer, name + " is web programmer");
		this.skill = new Html();
	}

	@Override
	public void useOs() {
		computer.useOs();
	}
}
