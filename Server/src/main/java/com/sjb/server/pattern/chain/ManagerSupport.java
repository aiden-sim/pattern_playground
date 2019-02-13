package com.sjb.server.pattern.chain;

import com.sjb.server.model.Rank;

public class ManagerSupport extends RankSupport {
	public ManagerSupport(String name) {
		super(name);
	}

	@Override protected boolean resolve(Rank rank) {
		if (Rank.MANAGER.equals(rank)) {
			return true;
		} else {
			return false;
		}
	}

	@Override protected int done() {
		return 300;
	}
}
