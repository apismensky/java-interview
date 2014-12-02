package com.octanner.lists;

/**
 * Both operations should be a constant time.
 * That's why we need to keep both tail and head
 */
public class Queue {
    private class QNode {
        QNode(QNode next, QNode prev, Object value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
        QNode next;
        QNode prev;
        Object value;
    }
    private QNode head;
    private QNode tail;

    public Queue add(Object o) {
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

    public Object poll() {
        if (this.tail == null)
            return null;
        Object value = this.tail.value;
        if (this.tail.prev != null)
            this.tail = this.tail.prev;
        else
            this.tail = null;
        return value;
    }
}
