package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.strategy.strategy.ObjectC;
import com.sjb.server.pattern.visitor.Visitor;

/**
 * Bridge 패턴
 * RefinedAbstraction(개선된 추상화)의 역할
 * <p>
 * Strategy 패턴 (Context)
 * <p>
 * Composite 패턴 (Leaf)
 * <p>
 * Visitor 패턴 (ConcreteElement)
 */
public class MobileProgrammer extends Programmer {
	public MobileProgrammer(Computer computer, String name) {
		super(computer);
		this.name = name;
		this.skill = new ObjectC();
	}

	@Override
	public void useOs() {
		Print print = PrintLog.newInstance(name + " is mobile programmer");
		print.printWithSout();
		computer.useOs();
	}

	@Override public int getPrice() {
		return 3200;
	}

	@Override public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
