package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.strategy.strategy.ProgramSkill;

/**
 * Bridge 패턴
 * Abstraction(추상화)의 역할
 * 기능 클래스
 * <p>
 * Strategy 패턴 (Context)
 */
public abstract class Programmer {
	protected final Computer computer;
	protected ProgramSkill skill;

	public Programmer(Computer computer, String log) {
		this.computer = computer;

		// log
		Print print = PrintLog.newInstance(log);
		print.printWithSout();
	}

	public abstract void useOs();

	public void getSkill() {
		Print print = PrintLog.newInstance(skill.getSkill() + " use");
		print.printWithSout();
	}
}