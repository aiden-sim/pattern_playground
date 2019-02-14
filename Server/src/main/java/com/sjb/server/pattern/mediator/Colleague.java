package com.sjb.server.pattern.mediator;

/**
 * Colleague(동료)의 역할
 */
public abstract class Colleague {
	protected Mediator mediator;
	protected String name;

	Colleague(Mediator mediator, String name) {
		this.mediator = mediator;
		this.name = name;
	}

	public abstract void sendMessages(String str);

	public abstract void receiveMessages(String str);
}
