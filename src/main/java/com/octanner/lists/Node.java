package com.octanner.lists;

class Node<T> {

    Node(Node linkedNode, T value) {
        this.linkedNode = linkedNode;
        this.value = value;
    }

    Node<T> linkedNode;
    T value;
}
