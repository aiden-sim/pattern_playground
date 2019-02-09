package com.sjb.server.pattern.factory;

import java.util.concurrent.atomic.LongAdder;

/**
 * ConcreteProduct(구체적인 제품)
 */
public class AnalysisStore extends Product {
    // 다형성 사용
    @Override
    protected void run(String name) {
        analysisDatabase.computeIfAbsent(name, x -> new LongAdder()).increment();
    }
}
