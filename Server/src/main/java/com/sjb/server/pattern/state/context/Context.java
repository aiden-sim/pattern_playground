package com.sjb.server.pattern.state.context;

import com.sjb.server.pattern.state.state.State;
import com.sjb.server.pattern.state.state.Work;

/**
 * Context(상황, 전후관계, 문맥)의 역할
 */
public class Context {
	// 기본
	private State state = Work.getInstance();

	public void setState(State state) {
		this.state = state;
	}

	public void changed(int hour) {
		state.changed(this, hour);
	}

	public void action() {
		state.action();
	}
}
