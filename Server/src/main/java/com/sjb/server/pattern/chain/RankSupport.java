package com.sjb.server.pattern.chain;

import com.sjb.server.model.Rank;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;

/**
 * Handler(처리자)의 역할
 */
public abstract class RankSupport {
	private String name;
	private RankSupport next;

	public RankSupport(String name) {
		this.name = name;
	}

	protected abstract boolean resolve(Rank rank);

	protected abstract int done();

	public RankSupport setNext(RankSupport next) {
		this.next = next;
		return next;
	}

	public final void support(Rank rank) {
		if (resolve(rank)) {
			Print print = PrintLog.newInstance(name + "(" + rank + ")" + "님의 인센티브는 " + done() + "만원 입니다.");
			print.printWithSout();
		} else if (next != null) {
			next.support(rank);
		} else {
			fail();
		}
	}

	private void fail() {
		Print print = PrintLog.newInstance("직급이 없습니다.");
		print.printWithSout();
	}

}
