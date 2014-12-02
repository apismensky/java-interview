package com.octanner.lists;

public class Stack {

    private Node head;

    public Stack push(Object o) {
       if (o == null) {
           throw new NullPointerException("Can not push null");
       }
       this.head = new Node(head, o);
       return this;
    }

    public Object pop() {
        if (head == null) {
            throw new NullPointerException("Stack is empty");
        }
        Object value = this.head.value;
        if (this.head.linkedNode != null)
            this.head = this.head.linkedNode;
        else
            this.head = null;
        return value;
    }
}
