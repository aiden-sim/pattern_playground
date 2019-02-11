package com.sjb.server.pattern.bridge.abstraction;

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

	public Programmer(Computer computer) {
		this.computer = computer;
	}

	public abstract void useOs();

	public void setSkill(ProgramSkill skill) {
		this.skill = skill;
	}

	public String getSkill() {
		if (skill == null) {
			return "no skill";
		}
		return skill.getSkill();
	}
}