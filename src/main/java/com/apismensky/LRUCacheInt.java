package com.apismensky;

import com.google.common.annotations.VisibleForTesting;

import java.util.*;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * <p/>
 * get(key) - Get the value (will always be positive)
 * of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 * <p/>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p/>
 * Example:
 * <p/>
 * LRUCache cache = new LRUCache(2);
 * <p/>
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * <p/>
 * Current implementation is using HashMap to store the cache values
 * and doubly linked list to implement the Queue
 * The instance of LRUCache is storing both LRU and MRU elements.
 * Each time when element is accessed it will be moved to MRU pointer
 * When the queue will reach its capacity the LRU element will be dropped
 * <p/>
 * new LRUCache(3) Example with 3 elements
 * MRU -> D <-> A <-> C <- LRU
 * <p/>
 * 1st put for C: MRU -> C <- LRU
 * 2nd put for B: MRU -> B <-> C <- LRU
 * 1st get for C: MRU -> C <-> B <- LRU
 * 3rd put for A: MRU -> A <-> C <-> B LRU
 * 4th put for D: MRU -> D <-> A <-> C <- LRU (dropping B at LRU)
 */
public class LRUCacheInt {


    public static class Node {

        private Integer value;
        private Integer key;
        private Node prev;
        private Node next;

        public Integer getValue() {
            return value;
        }

        public Integer getKey() {
            return key;
        }


        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + (prev == null ? "none" : prev.key) + " -> (" + key + ", " + value + ") -> " + (next == null ? "none" : next.key) + "]";
        }

        @Override
        public boolean equals(Object that) {
            return (that != null && that instanceof Node && ((Node) that).getKey().equals(this.getKey()) && ((Node) that).getValue().equals(this.getValue()));
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

    }

    private final long capacity;

    private final Map<Integer, Node> cache;

    @VisibleForTesting
    Node lruNode;

    @VisibleForTesting
    Node mruNode;

    public LRUCacheInt(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<Integer, Node>(capacity);
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        if (node.equals(this.mruNode)) return node.getValue();
        moveToMru(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        // Do not create a new node when it already exists
        boolean containsKey = cache.containsKey(key);
        if (containsKey) {
            node = cache.get(key);
            node.setValue(value);
        } else
            node = new Node(key, value);

        if (this.lruNode == null) this.lruNode = node;

        if (this.mruNode == null) this.mruNode = node;
        else if (!containsKey) {
            // Put this new node to MRU
            node.setNext(this.mruNode);
            this.mruNode.setPrev(node);
            this.mruNode = node;
        } else if (this.mruNode != node) // contains key and !mruCacheNode - detach the node and put to mru
            moveToMru(node);

        if (cache.size() == this.capacity && !containsKey && this.cache.containsKey(this.lruNode.key)) {
            // detach lru element
            Node removedNode = this.cache.remove(this.lruNode.key);
            //System.out.println("Detaching node from LRU " + removedNode);
            this.lruNode = removedNode.getPrev();
            this.lruNode.setNext(null);
            removedNode.setPrev(null);
            //System.out.println("New LRU " + this.lruCacheNode);
        }

        this.cache.put(key, node);
    }

    /**
     * Move the node to mruCacheNode
     *
     * @param node CacheNode
     */
    private void moveToMru(Node node) {
        if (node == this.lruNode) {
            this.lruNode = node.getPrev();
            node.getPrev().setNext(null);
            node.setPrev(null);
        } else {
            Node next = node.getNext();
            Node prev = node.getPrev();
            if (next != null) next.setPrev(prev);
            if (prev != null) prev.setNext(next);
        }

        Node oldMru = this.mruNode;
        this.mruNode = node;
        this.mruNode.setNext(oldMru);
        oldMru.setPrev(mruNode);
        this.mruNode.setPrev(null);
    }


}





