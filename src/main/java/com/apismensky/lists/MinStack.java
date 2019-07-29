package com.apismensky.lists;

/**
 * Complexity: Easy
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    private class N {
        N(N linkedNode, int value) {
            this.linkedNode = linkedNode;
            this.value = value;
        }
        N linkedNode;
        int value;
    }

    private N head;
    private int min = Integer.MAX_VALUE;

    public void push(int x) {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if (x <= min) {
            this.head = new N(head, min);
            min = x;
        }
        this.head = new N(head, x);
    }

    public void pop() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }

        if (this.head.value == this.min) {
            this.min = this.head.linkedNode.value;
            this.head = this.head.linkedNode;
        }
        this.head = this.head.linkedNode;
    }

    public int top() {
        if (isEmpty())
            throw new NullPointerException("Stack is empty");
        return this.head.value;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int getMin() {
        return min;
    }
}


