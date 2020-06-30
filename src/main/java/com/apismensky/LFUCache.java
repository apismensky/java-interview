package com.apismensky;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and
 * put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1. put(key, value) -
 * Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least
 * frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that
 * have the same frequency), the least recently used key would be evicted.
 *
 * Follow up: Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LFUCache cache = new LFUCache( 2 ); cache.put(1,1); cache.put(2,2); cache.get(1);       // returns 1 cache.put(3,3);    // evicts
 * key 2 cache.get(2);       // returns -1 (not found) cache.get(3);       // returns 3. cache.put(4,4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found) cache.get(3);       // returns 3 cache.get(4);       // returns 4
 *
 * Obviously, we need a hashmap to remember key-value pair. What we need to do, is to remember (frequency, recentness) for each key;
 * and sort them to get the smallest one. So, we need to use Collection such as TreeSet or PriorityQueue.
 *
 * Now, the only question is, how to update? It is difficult to update (frequency, recentness) in the collection, as we don't know the
 * index. (Maybe using binary search or hashmap can do this, I haven't tried it.)
 *
 * The trick is, just override equals() and hashCode() function, in order to use remove.
 *
 * Here is the code with detailed comment.
 */
public class LFUCache {

    class Cache implements Comparable<Cache> {
        int key, f, r;

        public Cache(int k, int f, int r) {
            key = k;
            this.f = f;
            this.r = r;
        }

        public boolean equals(Object object) {
            return key == ((Cache)object).key;
        }

        public int hashCode() {
            return key;
        }

        public int compareTo(Cache o) {
            return key == o.key ? 0 : f == o.f ? r - o.r : f - o.f;
        }
    }

    int capacity, id;
    HashMap<Integer, Integer> hashMap;
    HashMap<Integer, Cache> caches;
    TreeSet<Cache> treeSet;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        id = 0;
        hashMap = new HashMap<>();
        caches = new HashMap<>();
        treeSet = new TreeSet<>();
    }

    public int get(int key) {
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            return hashMap.get(key);
        }
        return -1;
    }

    public void set(int key, int value) {
        if (capacity == 0) {
            return;
        }
        id++;
        if (hashMap.containsKey(key)) {
            update(key);
            hashMap.put(key, value);
            return;
        }
        if (hashMap.size() == capacity) {
            Cache first = treeSet.pollFirst();
            hashMap.remove(first.key);
            caches.remove(first.key);
        }
        hashMap.put(key, value);
        Cache cache = new Cache(key, 1, id);
        caches.put(key, cache);
        treeSet.add(cache);
    }

    private void update(int key) {
        int f = caches.get(key).f;
        treeSet.remove(caches.get(key));
        Cache cache = new Cache(key, f + 1, id);
        caches.put(key, cache);
        treeSet.add(cache);
    }

}
