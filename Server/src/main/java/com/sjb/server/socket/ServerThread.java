package com.sjb.server.socket;

import com.sjb.common.pattern.command.command.Command;
import com.sjb.common.pattern.iterator.CommandAggregate;
import com.sjb.common.pattern.iterator.Iterator;
import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.factory.creator.CommandFactory;
import com.sjb.server.pattern.factory.creator.Factory;
import com.sjb.server.pattern.factory.product.Product;
import com.sjb.server.pattern.interpreter.Context;
import com.sjb.server.pattern.interpreter.Expression;
import com.sjb.server.pattern.interpreter.HangleExpression;
import com.sjb.server.pattern.interpreter.TerminalExpression;
import com.sjb.server.utility.NameCreator;
import org.apache.commons.lang3.BooleanUtils;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

            final String name = NameCreator.randomName();

            /**
             * Interpreter 패턴 (이름 유효성에 대한 해석기)
             */
            if (BooleanUtils.isNotTrue(isValid(name))) {
                Print print = PrintLog.newInstance("이름이 유효하지 않습니다");
                print.printWithSout();
            }

            // Iterator 패턴을 사용함으로써 구체적인 구현을 분리시킬 수 있다. ex) Map, List
            if (!Objects.isNull(aggregate) && !Objects.isNull(aggregate.iterator())) {
                Iterator iterator = aggregate.iterator();
                String nowDt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                while (iterator.hasNext()) {
                    Command command = (Command) iterator.next();
                    /**
                     * Factory를 Singleton 으로 생성
                     */
                    Factory factory = CommandFactory.getInstance();

                    /**
                     * Factory Method 패턴을 사용해서 각 Command 수행 (Abstract Factory로 개선 여지 있음)
                     */
                    Product product = factory.create(command.getCommandType());
                    if (!Objects.isNull(product)) {
                        product.execute(command.getCommandType(), name, nowDt);
                    }
                }
            }

            printWriter.write("ok");
            printWriter.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean isValid(String name) {
        Expression min = new TerminalExpression(1, "min");
        Expression max = new TerminalExpression(5, "max");
        Expression hangle = new HangleExpression(min, max);
        return hangle.interpret(new Context(name));
    }
}
