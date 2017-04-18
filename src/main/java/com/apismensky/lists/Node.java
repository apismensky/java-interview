package com.apismensky.lists;

class Node<T> {

    Node(Node<T> linkedNode, T value) {
        this.linkedNode = linkedNode;
        this.value = value;
    }

    Node<T> linkedNode;
    T value;
}
