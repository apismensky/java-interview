package com.apismensky.reversepolish;

import java.util.function.BinaryOperator;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULT("*", (a, b) -> a * b),
    DIV("/", (a, b) -> a / b);

    private String sign;
    private BinaryOperator<Integer> action;

    Operation(String sign, BinaryOperator<Integer> action) {
        this.sign = sign;
        this.action = action;
    }

    public String getSign() {
        return sign;
    }

    public BinaryOperator<Integer> getAction() {
        return action;
    }

    public static Operation value(String sign) {
        for (Operation o : Operation.values())
            if (o.getSign().equals(sign)) return o;
        return null;
    }
}
