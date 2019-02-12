package com.sjb.server.pattern.composite;

import com.sjb.server.pattern.bridge.abstraction.Programmer;
import com.sjb.server.pattern.bridge.implementor.Computer;
import com.sjb.server.pattern.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite 패턴 (Composite)
 * <p>
 * Visitor 패턴 (ConcreteVisitor)
 */
public class ProgrammerManager extends Programmer {

	// 복수의 Leaf
	private List<Programmer> programmerList = new ArrayList<>();

	public ProgrammerManager(Computer computer) {
		super(computer);
	}

	public void addProgrammer(Programmer programmer) {
		programmerList.add(programmer);
	}

	@Override public void useOs() {

	}

	// composite
	@Override public int getPrice() {
		int price = 0;
		for (Programmer programmer : programmerList) {
			price += programmer.getPrice();
		}

		return price;
	}

	// visitor
	@Override public void accept(Visitor visitor) {
		for (Programmer programmer : programmerList) {
			programmer.accept(visitor);
		}
		//visitor.visit(this);
	}
}
