package com.sjb.server.pattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteMediator(구체적인 조정자, 중개자)의 역할
 */
public class ChatMediator implements Mediator {
	private List<Colleague> list = new ArrayList<Colleague>();

	public void appendUser(Colleague colleague) {
		list.add(colleague);
	}

	public void removeUser(Colleague colleague) {
		list.remove(colleague);
	}

	public void sendMessage(String message, Colleague sender) {
		for (Colleague colleague : list) {
			if (colleague != sender) {
				colleague.receiveMessages(message);
			}
		}
	}

	public void notice(String message) {
		for (Colleague colleague : list) {
			colleague.receiveMessages(message);
		}
	}
}
