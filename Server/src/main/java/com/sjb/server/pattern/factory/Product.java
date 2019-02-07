package com.sjb.server.pattern.factory;

import com.sjb.common.model.CommandType;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintCommand;

/**
 * Product(제품)
 * 인스턴스가 가져야할 인터페이스(API)를 결정하는 추상 클래스
 */
public abstract class Product {

	protected abstract void run();

	/**
	 * Adapter 패턴 사용
	 * 객체(위임) Adapter 패턴을 사용해서 Log 찍음
	 */
	private void log(CommandType commandType) {
		Print print = new PrintCommand(commandType);
		print.printWithLogger();
		print.printWithSout();
	}

	/**
	 * Teamplte MEthod 패턴 사용
	 */
	public final void execute(CommandType commandType) {
		log(commandType);
		run();
	}
}
