package com.sjb.server.pattern.interpreter;

public class HangleExpression implements Expression {
    final private Expression expr1;
    final private Expression expr2;

    public HangleExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(Context context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
