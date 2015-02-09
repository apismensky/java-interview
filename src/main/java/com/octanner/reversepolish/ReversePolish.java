package com.octanner.reversepolish;

import com.google.common.annotations.VisibleForTesting;
import com.octanner.lists.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p/>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p/>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolish {


    public int calculate(String[] args) {
        if (args == null) {
            throw new IllegalArgumentException("Array can not be null");
        }

        if (args.length == 0) {
            return 0;
        }

        Stack stack = new Stack();

        for (int i = 0; i < args.length; i++) {
            String e = args[i];
            Operation operation = Operation.value(e);
            if (operation != null) {
                // Perform operation
                try {
                    int first = (Integer) stack.pop();
                    int second = (Integer) stack.pop();
                    int r = operation.getAction().apply(second, first);
                    stack.push(r);
                }
                catch (NullPointerException npe) {
                    throw new IllegalArgumentException("Invalid input array", npe);
                }

            }
            else {
                // Put number in the stack
                stack.push(getNumber(e));
            }
        }
        return (Integer)stack.pop();
    }

    @VisibleForTesting
    int getNumber(String a) {
        return Integer.parseInt(a);
    }
}
