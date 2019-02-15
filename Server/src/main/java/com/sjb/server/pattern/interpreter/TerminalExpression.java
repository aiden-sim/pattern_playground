package com.sjb.server.pattern.interpreter;

public class TerminalExpression implements Expression {
    private int size;
    private String inequality;

    public TerminalExpression(int size, String inequality) {
        this.size = size;
        this.inequality = inequality;
    }

    @Override
    public boolean interpret(Context context) {
        if (context.getContext().length() > size && inequality.equals("min")) {
            return true;
        }

        if (context.getContext().length() < size && inequality.equals("max")) {
            return true;
        }

        return false;
    }
}
