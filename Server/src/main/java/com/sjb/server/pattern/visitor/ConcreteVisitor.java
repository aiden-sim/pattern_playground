package com.sjb.server.pattern.visitor;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.abstraction.MobileProgrammer;
import com.sjb.server.pattern.bridge.abstraction.SystemProgrammer;
import com.sjb.server.pattern.bridge.abstraction.WebProgrammer;
import com.sjb.server.pattern.composite.ProgrammerManager;

/**
 * ConcreteVisitor
 */
public class ConcreteVisitor implements Visitor {
	@Override public void visit(MobileProgrammer programmer) {
		Print print = PrintLog.newInstance("mobile programmer 연봉 : " + programmer.getPrice());
		print.printWithSout();
	}

	@Override public void visit(SystemProgrammer programmer) {
		Print print = PrintLog.newInstance("system programmer 연봉 : " + programmer.getPrice());
		print.printWithSout();
	}

	@Override public void visit(WebProgrammer programmer) {
		Print print = PrintLog.newInstance("web programmer 연봉 : " + programmer.getPrice());
		print.printWithSout();
	}

	@Override public void visit(ProgrammerManager programmerManager) {
		Print print = PrintLog.newInstance("연봉을 표시할 수 없습니다.");
		print.printWithSout();
	}
}
