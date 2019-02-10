package com.sjb.server.pattern.bridge.implementor;

import com.sjb.server.pattern.adapter.Print;
import com.sjb.server.pattern.adapter.PrintLog;

/**
 * Bridge 패턴
 * Concrete Implementor(구체적인 구현자)의 역할
 */
public class Linux implements Computer {
    @Override
    public void useOs() {
        Print print = PrintLog.newInstance("linux os use");
        print.printWithSout();
    }
}
