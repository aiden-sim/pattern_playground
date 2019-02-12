package com.sjb.server.pattern.visitor;

import com.sjb.server.pattern.bridge.abstraction.MobileProgrammer;
import com.sjb.server.pattern.bridge.abstraction.SystemProgrammer;
import com.sjb.server.pattern.bridge.abstraction.WebProgrammer;
import com.sjb.server.pattern.composite.ProgrammerManager;

/**
 * Visitor (처리)
 * ConcreteElement가 추가되면 ConcreteVisitor에 새로운 visit 메소드를 구현해야 된다.
 */
public interface Visitor {
	void visit(MobileProgrammer programmer);

	void visit(SystemProgrammer programmer);

	void visit(WebProgrammer programmer);

	void visit(ProgrammerManager programmerManager);
}
