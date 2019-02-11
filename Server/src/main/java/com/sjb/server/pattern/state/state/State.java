package com.sjb.server.pattern.state.state;

import com.sjb.server.pattern.state.context.Context;

/**
 * State(상태)의 역할
 */
public interface State {
	void changed(Context context, int hour);

	void action();
}
