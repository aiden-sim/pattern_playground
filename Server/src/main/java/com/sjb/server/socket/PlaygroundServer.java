package com.sjb.server.socket;

import com.sjb.server.pattern.memento.CareTaker;
import com.sjb.server.pattern.memento.Originator;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 참고
 * https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class PlaygroundServer {
    private static final int port = 1986;

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Playground Server ON!!!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");

                /**
                 * Memento 패턴 (접속 기록)
                 */
                originator.setIp(serverSocket.getInetAddress().toString());
                originator.setLocalDateTime(LocalDateTime.now());
                careTaker.add(originator.saveToMemento());
                originator.getFromMemento(careTaker.get(careTaker.getSize()));
                System.out.println(originator.getState());

                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server Broken T.T : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
