package com.apismensky.lists;

/**
 * Complexity: Easy
 *
 * Implement simple Queue
 * Both operations should be a constant time.
 * That's why we need to keep both tail and head
 *
 */
public class Queue<T> {
    private class QNode {
        QNode(QNode next, QNode prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
        QNode next;
        QNode prev;
        T value;
    }
    private QNode head;
    private QNode tail;

    public Queue<T> add(T o) {
        if (o == null)
            throw new NullPointerException("Can not add null");
        QNode qNode = new QNode(head, null, o);
        if (this.head != null)
            this.head.prev = qNode;
        if (this.tail == null)
            this.tail = qNode;
        this.head = qNode;
        return this;
    }

    public T poll() {
        if (this.tail == null)
            return null;
        T value = this.tail.value;
        if (this.tail.prev != null)
            this.tail = this.tail.prev;
        else
            this.tail = null;
        return value;
    }
}
