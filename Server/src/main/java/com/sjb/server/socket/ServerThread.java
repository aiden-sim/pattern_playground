package com.sjb.server.socket;

import com.sjb.common.model.Command;
import com.sjb.common.pattern.iterator.CommandAggregate;
import com.sjb.common.pattern.iterator.Iterator;
import com.sjb.server.pattern.factory.CommandFactory;
import com.sjb.server.pattern.factory.Factory;
import com.sjb.server.pattern.factory.Product;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class ServerThread extends Thread {
	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		/**
		 * try-with-resource를 사용하려면 내부적으로 AutoCloseable 구현
		 */
		try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
				ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
			CommandAggregate aggregate = (CommandAggregate) objectInputStream.readObject();

			// Iterator 패턴을 사용함으로써 구체적인 구현을 분리시킬 수 있다. ex) Map, List
			if (!Objects.isNull(aggregate) && !Objects.isNull(aggregate.iterator())) {
				Iterator iterator = aggregate.iterator();
				while (iterator.hasNext()) {
					Command command = (Command) iterator.next();

					/**
					 * Factory를 Singleton 으로 생성
					 */
					Factory factory = CommandFactory.getInstance();
					/**
					 * Factory Method 패턴을 사용해서 각 Command 수행
					 */
					Product product = factory.create(command.getCommandType());
					if (!Objects.isNull(product)) {
						product.execute(command.getCommandType());
					}
				}
			}

			printWriter.write("ok");
			printWriter.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
