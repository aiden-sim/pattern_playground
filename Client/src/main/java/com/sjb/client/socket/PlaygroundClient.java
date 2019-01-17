package com.sjb.client.socket;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PlaygroundClient {
    private final static String hostname = "localhost";
    private final static int port = 1986;

    public static void main(String[] args) {
        try (Socket socket = new Socket(hostname, port);
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            String text;

            do {
                // 랜덤으로 전문 생성 (request)
                text = "bye2";
                writer.println(text);

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String time = reader.readLine();

                System.out.println(time);
            } while (!"bye".equals(text));
        } catch (UnknownHostException ex) {
            System.out.println("Server not found T.T : " + ex.getMessage());
            ex.printStackTrace();
        } catch (IOException ex2) {
            System.out.println("I/O error: " + ex2.getMessage());
            ex2.printStackTrace();
        }
    }
}
