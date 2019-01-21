package com.sjb.client.socket;

import com.sjb.common.model.Command;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PlaygroundClient {
    private final static String hostname = "localhost";
    private final static int port = 1986;

    public static void main(String[] args) {

        try (Socket socket = new Socket(hostname, port);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
             BufferedReader bufferReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            Command command = new Command();
            command.setValue("test");
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();

            String returnMessage = bufferReader.readLine();
            System.out.println("returnMessage : " + returnMessage);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
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
        */
    }
}
