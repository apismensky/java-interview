package com.octanner.lists;

public class Stack<T> {

    private Node<T> head;

    public Stack push(T o) {
       if (o == null)
           throw new NullPointerException("Can not push null");
       this.head = new Node<T>(head, o);
       return this;
    }

    public T pop() {
        if (head == null)
            throw new NullPointerException("Stack is empty");
        T value = this.head.value;
        if (this.head.linkedNode != null)
            this.head = this.head.linkedNode;
        else
            this.head = null;
        return value;
    }
}
