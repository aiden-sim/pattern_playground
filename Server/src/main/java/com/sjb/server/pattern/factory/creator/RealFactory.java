package com.sjb.server.pattern.factory.creator;

import com.sjb.common.model.CommandType;
import com.sjb.server.pattern.factory.product.*;

/**
 * Proxy 패턴 (RealSubject)
 */
public class RealFactory extends Factory {
	@Override
	public Product create(CommandType commandType) {
		switch (commandType) {
			case ANALYSIS_DATA_STORE:
				return new AnalysisStore();
			case ANALYSIS_DATA_SEARCH:
				return new AnalysisSearch();
			case REALTIME_DATA_STORE:
				return new RealTimeStore();
			case REALTIME_DATA_SEARCH:
				return new RealTimeSearch();
			case PROCESSING_DATA_STORE:
				return new ProcessingDataStore();
			case PROCESSING_DATA_SERACH:
				return new ProcessingDataSearch();
			case TOTAL_DATA_SEARCH:
				return new TotalDataSearch();
			default:
				return null;
		}
	}
}
