package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.strategy.strategy.ProgramSkill;
import com.sjb.server.pattern.visitor.Visitor;

/**
 * Bridge 패턴
 * Abstraction(추상화)의 역할
 * 기능 클래스
 * <p>
 * Strategy 패턴 (Context)
 * <p>
 * Composite 패턴 (Component)
 * <p>
 * Visitor 패턴 (Element) (구조)
 */
public abstract class Programmer {
	protected final Computer computer;
	protected ProgramSkill skill;
	protected String name;

	public Programmer(Computer computer) {
		this.computer = computer;
	}

	public abstract void useOs();

	// composite
	public abstract int getPrice();

	// visitor
	public abstract void accept(Visitor visitor);

	public void getSkill() {
		Print print = PrintLog.newInstance(skill.getSkill() + " use");
		print.printWithSout();
	}
}