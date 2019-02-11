package com.sjb.server.pattern.state.state;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.state.context.Context;

/**
 * ConcreteState(구체적인 상태)의 역할
 */
public class Work implements State {
	private static Work singleton = new Work();

	public static State getInstance() {
		return singleton;
	}

	private Work() {

	}

	@Override public void changed(Context context, int hour) {
		if (12 <= hour && hour <= 13) {
			context.setState(Rest.getInstance());
		} else if (9 <= hour || hour >= 18) {
			context.setState(Leave.getInstance());
		}
	}

	@Override public void action() {
		Print print = PrintLog.newInstance("근무중");
		print.printWithSout();
	}
}
