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
import com.sjb.server.pattern.bridge.implementor.None;
import com.sjb.server.pattern.bridge.implementor.Window;
import com.sjb.server.pattern.chain.ChainClient;
import com.sjb.server.pattern.composite.ProgrammerManager;
import com.sjb.server.pattern.state.context.Context;
import com.sjb.server.pattern.visitor.ConcreteVisitor;
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

	private ProgrammerManager manager = new ProgrammerManager(new None());
	private ChainClient chain = new ChainClient();

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

				/**
				 *  Chain of Responsibility 패턴을 이용한 직급에 따른 인센티브 통보
				 */
				chain.execute(name, userInfo.getRank());

			});
			/**
			 * Visitor 패턴을 이용한 연봉 통보
			 */
			manager.accept(new ConcreteVisitor());

			/**
			 * Composite 패턴을 이용한 총 연봉
			 */
			Print print = PrintLog.newInstance("총 연봉 : " + manager.getPrice());
			print.printWithSout();
		}
	}

	private Programmer getProgrammer(DetailUserInfo userInfo) {
		switch (userInfo.getProgram()) {
			case WEB:
				Programmer web = new WebProgrammer(new Window(), userInfo.getName());
				manager.addProgrammer(web);
				return web;
			case MOBILE:
				Programmer mobile = new MobileProgrammer(new Mac(), userInfo.getName());
				manager.addProgrammer(mobile);
				return mobile;
			case SYSTEM:
				Programmer system = new SystemProgrammer(new Linux(), userInfo.getName());
				manager.addProgrammer(system);
				return system;
			default:
				return null;
		}
	}
}
