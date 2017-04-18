package com.apismensky.reversepolish;

public enum Operation {
    PLUS("+", new OperationAction() {
        public int apply(int a, int b) {
            return a + b;
        }
    }),
    MINUS("-", new OperationAction() {
        public int apply(int a, int b) {
            return a - b;
        }
    }),
    MULT("*", new OperationAction() {
        public int apply(int a, int b) {
            return a * b;
        }
    }),
    DIV("/", new OperationAction() {
        public int apply(int a, int b) {
            return a / b;
        }
    });

    private String sign;
    private OperationAction action;

    Operation(String sign, OperationAction action) {
        this.sign = sign;
        this.action = action;
    }

    public String getSign() {
        return sign;
    }

    public OperationAction getAction() {
        return action;
    }

    public static Operation value(String sign) {
        for (Operation o : Operation.values())
            if (o.getSign().equals(sign)) return o;
        return null;
    }
}
