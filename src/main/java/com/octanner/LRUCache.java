package com.octanner;

import com.google.common.annotations.VisibleForTesting;

import java.util.HashMap;
import java.util.Map;

/**
 Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

 get(key) - Get the value (will always be positive)
     of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present.
     When the cache reached its capacity, it should invalidate the least recently
     used item before inserting a new item.

 Follow up:
 Could you do both operations in O(1) time complexity?

 Example:

 LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns null (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns null (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

 * Current implementation is using HashMap to store the cache values
 * and doubly linked list to implement the Queue
 * The instance of LRUCache is storing both LRU and MRU elements.
 * Each time when element is accessed it will be moved to MRU pointer
 * When the queue will reach its capacity the LRU element will be dropped
 *
 *               new LRUCache(3) Example with 3 elements
 *         MRU -> D <-> A <-> C <- LRU
 *
 * 1st put for C: MRU -> C <- LRU
 * 2nd put for B: MRU -> B <-> C <- LRU
 * 1st get for C: MRU -> C <-> B <- LRU
 * 3rd put for A: MRU -> A <-> C <-> B LRU
 * 4th put for D: MRU -> D <-> A <-> C <- LRU (dropping B at LRU)
 *
 * @param <K> key type
 * @param <V> value type
 */
public class LRUCache <K,V> {


    public static class CacheNode<K,V> {

        private V value;
        private final K key;
        private CacheNode<K,V> prev;
        private CacheNode<K,V> next;

        public CacheNode(K key, V value) {
            this.key = key;
            this.value = value;
        }


        public  CacheNode<K,V> getPrev() {
            return prev;
        }

        public void setPrev(CacheNode<K,V> prev) {
            this.prev = prev;
        }

        public CacheNode<K,V> getNext() {
            return next;
        }

        public void setNext(CacheNode<K,V> next) {
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "[" + (prev == null ? "none" : prev.key) + " -> (" + key + ", " + value + ") -> " + (next == null ? "none" : next.key) + "]";
        }

        @Override
        public boolean equals(Object that) {
            return (that != null && that instanceof CacheNode && ((CacheNode) that).getKey().equals(this.getKey()) && ((CacheNode) that).getValue().equals(this.getValue()));
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }

    private final int capacity;

    private final Map<K, CacheNode<K,V>> cache;

    @VisibleForTesting
    CacheNode<K,V> lruNode;

    @VisibleForTesting
    CacheNode<K,V> mruNode;

    /**
     * Constructor
     * @param capacity initial capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<K, CacheNode<K,V>>(capacity);
    }

    /**
     * Get the value (will always be positive)
     * of the key if the key exists in the cache, otherwise return null
     * Most recently used node should be
     * @param key key
     * @return value value
     */
    public V get(K key) {
        CacheNode<K, V> cacheNode = cache.get(key);
        if (cacheNode == null) return null;
        if (cacheNode.equals(this.mruNode)) return cacheNode.getValue();
        moveToMru(cacheNode);
        return cacheNode.value;
    }

    public void put(K key, V value) {
        CacheNode<K,V> node;
        // Do not create a new node when it already exists
        boolean containsKey = cache.containsKey(key);
        if (containsKey) {
            node = cache.get(key);
            node.setValue(value);
        } else
            node = new CacheNode<K,V>(key, value);

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
            CacheNode<K,V> removedNode = this.cache.remove(this.lruNode.key);
            this.lruNode = removedNode.getPrev();
            this.lruNode.setNext(null);
            removedNode.setPrev(null);
        }

        this.cache.put(key, node);
    }

    /**
     * Move the cacheNode to mruCacheNode
     *
     * @param cacheNode CacheNode
     */
    private void moveToMru(CacheNode<K,V> cacheNode) {
        if (cacheNode == this.lruNode) {
            this.lruNode = cacheNode.getPrev();
            cacheNode.getPrev().setNext(null);
            cacheNode.setPrev(null);
        } else {
            CacheNode<K,V> next = cacheNode.getNext();
            CacheNode<K,V> prev = cacheNode.getPrev();
            if (next != null) next.setPrev(prev);
            if (prev != null) prev.setNext(next);
        }

        CacheNode<K,V> oldMru = this.mruNode;
        this.mruNode = cacheNode;
        this.mruNode.setNext(oldMru);
        oldMru.setPrev(mruNode);
        this.mruNode.setPrev(null);
    }

}
