package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.strategy.strategy.Java;

/**
 * Bridge 패턴
 * RefinedAbstraction(개선된 추상화)의 역할
 * <p>
 * Strategy 패턴 (Context)
 */
public class SystemProgrammer extends Programmer {
	public SystemProgrammer(Computer computer, String name) {
		super(computer);
		this.name = name;
		this.skill = new Java();
	}

	@Override
	public void useOs() {
		Print print = PrintLog.newInstance(name + " is system programmer");
		print.printWithSout();
		computer.useOs();
	}
}
