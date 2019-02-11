package com.sjb.server.pattern.factory.product;

import com.sjb.server.model.DetailUserInfo;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.abstraction.MobileProgrammer;
import com.sjb.server.pattern.bridge.abstraction.Programmer;
import com.sjb.server.pattern.bridge.abstraction.SystemProgrammer;
import com.sjb.server.pattern.bridge.abstraction.WebProgrammer;
import com.sjb.server.pattern.bridge.implementor.Linux;
import com.sjb.server.pattern.bridge.implementor.Mac;
import com.sjb.server.pattern.bridge.implementor.Window;
import com.sjb.server.pattern.strategy.strategy.Html;
import com.sjb.server.pattern.strategy.strategy.Java;
import com.sjb.server.pattern.strategy.strategy.ObjectC;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDateTime;
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
				 * 프로그래별 스킬을 Strategy 패턴으로 구현
				 */
				if (programmer instanceof WebProgrammer) {
					programmer.setSkill(new Html());
				}

				if (programmer instanceof MobileProgrammer) {
					programmer.setSkill(new ObjectC());
				}

				if (programmer instanceof SystemProgrammer) {
					programmer.setSkill(new Java());
				}

				Print print = PrintLog.newInstance(programmer.getSkill() + " use");
				print.printWithSout();
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
