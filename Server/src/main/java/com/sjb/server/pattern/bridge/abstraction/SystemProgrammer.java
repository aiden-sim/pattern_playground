package com.sjb.server.pattern.bridge.abstraction;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;
import com.sjb.server.pattern.bridge.implementor.Computer;

/**
 * Bridge 패턴
 * RefinedAbstraction(개선된 추상화)의 역할
 */
public class SystemProgrammer extends Programmer {
    private String name;

    public SystemProgrammer(Computer computer, String name) {
        super(computer);
        this.name = name;
    }

    @Override
    public void useOs() {
        Print print = PrintLog.newInstance(name + " is SystemProgrammer");
        print.printWithSout();
        computer.useOs();
    }
}
