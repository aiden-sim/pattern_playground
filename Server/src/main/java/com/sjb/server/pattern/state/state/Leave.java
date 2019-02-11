package com.sjb.server.pattern.state.state;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.state.context.Context;

/**
 * ConcreteState(구체적인 상태)의 역할
 */
public class Leave implements State {
	private static Leave singleton = new Leave();

	public static State getInstance() {
		return singleton;
	}

	private Leave() {

	}

	@Override public void changed(Context context, int hour) {
		if (12 <= hour && hour <= 13) {
			context.setState(Rest.getInstance());
		} else if (9 <= hour && hour <= 18) {
			context.setState(Work.getInstance());
		}
	}

	@Override public void action() {
		Print print = PrintLog.newInstance("퇴근");
		print.printWithSout();
	}
}
