package com.sjb.server.pattern.mediator;

/**
 * ConcreteColleague(구체적인 동료)의 역할
 */
public class User extends Colleague {

	public User(Mediator mediator, String name) {
		super(mediator, name);
	}

	public void sendMessages(String str) {
		System.out.println("send : " + str);
		mediator.sendMessage(str, this);
	}

	public void receiveMessages(String str) {
		System.out.println(name + " recv : " + str);
	}
}
