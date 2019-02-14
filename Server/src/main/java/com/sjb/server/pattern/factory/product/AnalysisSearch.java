package com.sjb.server.pattern.factory.product;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;

import java.util.concurrent.atomic.LongAdder;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 */
public class AnalysisSearch extends Product {
	// 다형성 사용
	@Override
	protected void run(String name, String nowDt) {
		LongAdder result = getAnalysisDatabase(nowDt);
		if (result != null) {
			final String log = nowDt + "_" + result.sum();
			Print print = PrintLog.newInstance(log);
			print.printWithSout();
		}
	}
}
