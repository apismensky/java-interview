package com.octanner.lists;

class Node {

    Node(Node linkedNode, Object value) {
        this.linkedNode = linkedNode;
        this.value = value;
    }

    Node linkedNode;
    Object value;
}
