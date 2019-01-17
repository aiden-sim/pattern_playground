package com.sjb.server.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 참고
 * https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class PlaygroundServer {
    private static final int port = 1986;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Playground Server ON!!!");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");

                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server Broken T.T : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
