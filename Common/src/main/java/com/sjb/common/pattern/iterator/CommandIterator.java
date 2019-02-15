package com.sjb.common.pattern.iterator;

import com.sjb.common.pattern.command.command.Command;

/**
 * Iterator 패턴
 * ConcreteIterator(구체적인 반복자)
 * Iterator가 결정한 인터페이스를 실제로 구현
 */
public class CommandIterator implements Iterator {
    private CommandAggregate commandAggregate;
    private int index;

    public CommandIterator(CommandAggregate commandAggregate) {
        this.commandAggregate = commandAggregate;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < commandAggregate.getLength()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Command command = commandAggregate.getCommandAt(index);
        index++;
        return command;
    }
}
