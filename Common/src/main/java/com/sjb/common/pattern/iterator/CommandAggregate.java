package com.sjb.common.pattern.iterator;

import com.sjb.common.pattern.command.command.Command;

import java.io.Serializable;

/**
 * Iterator 패턴
 * ConcreteAggregate(구체적인 집합체)
 * Aggregate 역할이 결정한 인터페이스를 실제로 구현하는 일
 *
 * Command 패턴 (Invoker) 완벽한 Invoker 역할은 아니고 Command를 저장하는 용도
 */
public class CommandAggregate implements Aggregate, Serializable {
    private static final long serialVersionUID = 721159619438305544L;
    private Command[] commands;
    private int last = 0;

    public CommandAggregate(int maxSize) {
        this.commands = new Command[maxSize];
    }

    public Command getCommandAt(int index) {
        return commands[index];
    }

    public void appendCommand(Command command) {
        this.commands[last] = command;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new CommandIterator(this);
    }
}
