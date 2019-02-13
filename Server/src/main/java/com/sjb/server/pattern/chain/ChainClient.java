package com.sjb.server.pattern.chain;

import com.sjb.server.model.Rank;

public class ChainClient {
	public void execute(String name, Rank rank) {
		RankSupport staff = new StaffSupport(name);
		RankSupport assistant = new AssistantManagerSupport(name);
		RankSupport manager = new ManagerSupport(name);
		RankSupport senior = new SeniorManagerSupport(name);

		staff.setNext(assistant).setNext(manager).setNext(senior);
		staff.support(rank);
	}
}
