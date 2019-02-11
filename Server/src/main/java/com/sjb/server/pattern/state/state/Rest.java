package com.sjb.server.pattern.state.state;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.state.context.Context;

/**
 * ConcreteState(구체적인 상태)의 역할
 */
public class Rest implements State {
	private static Rest singleton = new Rest();

	public static State getInstance() {
		return singleton;
	}

	private Rest() {

	}

	@Override public void changed(Context context, int hour) {
		if ((9 <= hour && hour <= 12) || (13 <= hour && hour <= 18)) {
			context.setState(Work.getInstance());
		} else if (9 <= hour || hour >= 18) {
			context.setState(Leave.getInstance());
		}
	}

	@Override public void action() {
		Print print = PrintLog.newInstance("휴식중");
		print.printWithSout();
	}
}
