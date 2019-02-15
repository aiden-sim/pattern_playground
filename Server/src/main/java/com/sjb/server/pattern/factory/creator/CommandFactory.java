package com.sjb.server.pattern.factory.creator;

import com.sjb.common.pattern.command.receiver.CommandType;
import com.sjb.server.pattern.factory.product.*;

/**
 * Factory Method 패턴
 * ConcreteCreator(구체적인 작성자)
 * <p>
 * Proxy 패턴(Proxy)
 */
public class CommandFactory extends Factory {
	private RealFactory realFactory;

	private static final CommandFactory INSTANCE = new CommandFactory();

	private CommandFactory() {
		if (INSTANCE != null) {
			throw new RuntimeException("중복 생성");
		}
	}

	/**
	 * Singleton 패턴
	 * 객체에 상태가 없어야 한다. Factory는 Singleton 패턴으로 설계되는 경우가 많다.
	 */
	public static CommandFactory getInstance() {
		return INSTANCE;
	}

	@Override
	public Product create(CommandType commandType) {
		switch (commandType) {
			case ANALYSIS_DATA_SEARCH:
				return new AnalysisSearch();
			case REALTIME_DATA_SEARCH:
				return new RealTimeSearch();
			case PROCESSING_DATA_SERACH:
				return new ProcessingDataSearch();
			case TOTAL_DATA_SEARCH:
				return new TotalDataSearch();
			default:
				// Store 부분은 RealSbuject로 조회
				// Lazy Loading
				if (realFactory == null) {
					realFactory = new RealFactory();
				}
				return realFactory.create(commandType);
		}
	}
}
