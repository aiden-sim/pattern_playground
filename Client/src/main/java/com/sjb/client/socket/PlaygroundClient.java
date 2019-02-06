package com.sjb.client.socket;

import com.sjb.common.model.Command;
import com.sjb.common.model.CommandType;
import com.sjb.common.pattern.iterator.CommandAggregate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
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
            CommandAggregate aggregate = new CommandAggregate(2);
            aggregate.appendCommand(new Command(CommandType.REALTIME));
            aggregate.appendCommand(new Command(CommandType.ANALYSIS));

            objectOutputStream.writeObject(aggregate);
            objectOutputStream.flush();

            String returnMessage = bufferReader.readLine();
            System.out.println("return Message : " + returnMessage);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
