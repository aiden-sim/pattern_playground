package com.sjb.server.pattern.factory.product;

import com.sjb.common.model.CommandType;
import com.sjb.server.model.DetailUserInfo;
import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;

/**
 * Factory Method 패턴
 * Product(제품)
 * 인스턴스가 가져야할 인터페이스(API)를 결정하는 추상 클래스
 */
public abstract class Product {
	protected static Map<String, List<UserInfo>> realtimeDatabase = new ConcurrentHashMap<>();
	protected static Map<String, LongAdder> analysisDatabase = new ConcurrentHashMap<>();
	protected static Map<String, List<DetailUserInfo>> processingDatabase = new ConcurrentHashMap<>();

	protected abstract void run(String name, String nowDt);

	/**
	 * Adapter 패턴 사용
	 * 객체(위임) Adapter 패턴을 사용해서 Log 찍음
	 */
	private void log(CommandType commandType) {
		Print print = PrintLog.newInstance(commandType.getName());
		print.printWithLogger();
		print.printWithSout();
	}

	/**
	 * Teamplte Method 패턴
	 */
	public final void execute(CommandType commandType, String name, String nowDt) {
		log(commandType);
		run(name, nowDt);
	}
}
