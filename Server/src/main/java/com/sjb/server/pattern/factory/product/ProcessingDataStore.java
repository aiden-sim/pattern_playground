package com.sjb.server.pattern.factory.product;

import com.sjb.server.model.*;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 */
public class ProcessingDataStore extends Product {
	private static final int MIN_AGE = 20;
	private static final int MAX_AGE = 60;
	private final Program[] programs = { Program.WEB, Program.MOBILE, Program.SYSTEM };
	private final Rank[] ranks = { Rank.STAFF, Rank.ASSISTANT_MANAGER, Rank.MANAGER, Rank.SENIOR_MANAGER };

	// 다형성 사용
	@Override
	protected void run(String name, String nowDt) {
		List<UserInfo> userInfoList = getRealtimeDatabase(nowDt);
		if (CollectionUtils.isNotEmpty(userInfoList)) {
			userInfoList.forEach(userInfo -> {
				/**
				 * Builder 패턴
				 */
				DetailUserInfo result = new DetailUserInfo.UserInfoBuilder()
						.setName(userInfo.getName())
						.setCreateDt(userInfo.getCreateDt())
						.setAge(MIN_AGE + (int) (Math.random() * ((MAX_AGE - MIN_AGE) + 1)))
						.setGender(((int) (Math.random() * Gender.values().length)) == 0 ? Gender.FEMALE : Gender.MALE)
						.setProgram(programs[(int) (Math.random() * programs.length)])
						.setRank(ranks[(int) (Math.random() * ranks.length)])
						.build();

				processingDatabase.computeIfAbsent(nowDt, x -> new ArrayList<>()).add(result);
			});
		}
	}
}
