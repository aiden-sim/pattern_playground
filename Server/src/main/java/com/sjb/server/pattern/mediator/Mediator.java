package com.sjb.server.pattern.mediator;

/**
 * Mediaor(조정자, 중개자)의 역할
 */
public interface Mediator {
	void appendUser(Colleague colleague);

	void removeUser(Colleague colleague);

	void sendMessage(String message, Colleague sender);

	void notice(String message);
}
