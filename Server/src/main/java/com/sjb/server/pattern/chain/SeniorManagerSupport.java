package com.sjb.server.pattern.chain;

import com.sjb.server.model.Rank;

public class SeniorManagerSupport extends RankSupport {
	public SeniorManagerSupport(String name) {
		super(name);
	}

	@Override protected boolean resolve(Rank rank) {
		if (Rank.SENIOR_MANAGER.equals(rank)) {
			return true;
		} else {
			return false;
		}
	}

	@Override protected int done() {
		return 400;
	}
}
