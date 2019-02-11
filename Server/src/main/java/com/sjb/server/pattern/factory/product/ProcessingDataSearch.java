package com.sjb.server.pattern.factory.product;

import com.sjb.server.model.DetailUserInfo;
import com.sjb.server.pattern.bridge.abstraction.MobileProgrammer;
import com.sjb.server.pattern.bridge.abstraction.Programmer;
import com.sjb.server.pattern.bridge.abstraction.SystemProgrammer;
import com.sjb.server.pattern.bridge.abstraction.WebProgrammer;
import com.sjb.server.pattern.bridge.implementor.Linux;
import com.sjb.server.pattern.bridge.implementor.Mac;
import com.sjb.server.pattern.bridge.implementor.Window;
import com.sjb.server.pattern.state.context.Context;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Factory Method 패턴
 * ConcreteProduct(구체적인 제품)
 */
public class ProcessingDataSearch extends Product {
	// 다형성 사용
	@Override
	protected void run(String name) {
		String nowDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		List<DetailUserInfo> userInfoList = processingDatabase.get(nowDt);
		if (CollectionUtils.isNotEmpty(userInfoList)) {
			userInfoList.forEach(userInfo -> {
				/**
				 * Bridge 패턴을 이용한 프로그래머에 맞는 장비 지급 후, 출력
				 */
				Programmer programmer = getProgrammer(userInfo);
				programmer.useOs();

				/**
				 * Strage 패턴을 이용해 프로그래머별 스킬 구현(다른 알고리즘)
				 */
				programmer.getSkill();

				/**
				 * State 패턴을 이용해서 현재 근무 상태 확인
				 */
				LocalTime currentTime = LocalTime.now();
				Context context = new Context();
				context.changed(currentTime.getHour());
				context.action();
			});
		}
	}

	private Programmer getProgrammer(DetailUserInfo userInfo) {
		switch (userInfo.getProgram()) {
			case WEB:
				return new WebProgrammer(new Window(), userInfo.getName());
			case MOBILE:
				return new MobileProgrammer(new Mac(), userInfo.getName());
			case SYSTEM:
				return new SystemProgrammer(new Linux(), userInfo.getName());
			default:
				return null;
		}
	}
}
