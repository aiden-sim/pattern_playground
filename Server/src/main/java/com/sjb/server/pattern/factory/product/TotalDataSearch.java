package com.sjb.server.pattern.factory.product;

import com.sjb.server.model.DetailUserInfo;
import com.sjb.server.model.Rank;
import com.sjb.server.model.UserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 * <p>
 * Facade 패턴 (Facade)
 */
public class TotalDataSearch extends Product {

	// 다형성 사용
	@Override
	protected void run(String name, String nowDt) {
		Print print = PrintLog.newInstance("user info - " + getInfo(name, nowDt));
		print.printWithSout();
	}

	/**
	 * Facade Method
	 */
	private String getInfo(String name, String nowDt) {
		String userName = getUserName(name, nowDt);
		Long count = getUserCount(nowDt);
		Rank rank = getUserRank(name, nowDt);
		return "userName : " + userName + ", count : " + count + ", rank : " + rank.toString();
	}

	/**
	 * Facade 패턴 (System1)
	 * 유저 이름 가지고 옴
	 */
	private String getUserName(String name, String nowDt) {
		List<UserInfo> userInfoList = getRealtimeDatabase(nowDt);
		return userInfoList.stream()
				.filter(info -> info.getName().equals(name))
				.map(UserInfo::getName)
				.findAny()
				.orElse(null);
	}

	/**
	 * Facade 패턴 (System2)
	 * 총 유저 수 가지고 옴
	 */
	private Long getUserCount(String nowDt) {
		LongAdder result = getAnalysisDatabase(nowDt);
		return result.longValue();
	}

	/**
	 * Facade 패턴 (System3)
	 * 직급 가지고 옴
	 */
	private Rank getUserRank(String name, String nowDt) {
		List<DetailUserInfo> userInfoList = getProcessingDatabase(nowDt);
		return userInfoList.stream()
				.filter(info -> info.getName().equals(name))
				.map(DetailUserInfo::getRank)
				.findAny()
				.orElse(null);
	}
}
