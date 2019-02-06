package com.sjb.server.socket;

import com.sjb.common.model.Command;
import com.sjb.common.pattern.iterator.CommandAggregate;
import com.sjb.common.pattern.iterator.Iterator;
import org.apache.commons.collections4.CollectionUtils;

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
                    System.out.println(command);
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


        /*
        try (InputStream input = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(input));
             OutputStream output = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(output, true)) {

            String text;
            do {
                text = reader.readLine();
                // 여기서 내 코드
                String reverseText = new StringBuilder(text).reverse().toString();
                writer.println("Server: " + reverseText);

            } while (!"bye".equals(text));
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }

}
