package com.sjb.server.pattern.chain;

import com.sjb.server.model.Rank;

public class AssistantManagerSupport extends RankSupport {
	public AssistantManagerSupport(String name) {
		super(name);
	}

	@Override protected boolean resolve(Rank rank) {
		if (Rank.ASSISTANT_MANAGER.equals(rank)) {
			return true;
		} else {
			return false;
		}
	}

	@Override protected int done() {
		return 200;
	}
}
