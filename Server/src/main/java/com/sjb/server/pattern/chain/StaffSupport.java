package com.sjb.server.pattern.chain;

import com.sjb.server.model.Rank;

public class StaffSupport extends RankSupport {
	public StaffSupport(String name) {
		super(name);
	}

	@Override protected boolean resolve(Rank rank) {
		if (Rank.STAFF.equals(rank)) {
			return true;
		} else {
			return false;
		}
	}

	@Override protected int done() {
		return 100;
	}
}
