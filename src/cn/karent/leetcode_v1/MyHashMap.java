package cn.karent.leetcode_v1;

import java.util.Objects;

/**
 * 设计哈希映射
 */
public class MyHashMap {

    private int capcity = 64;

    class Entry {
        private int key;
        private int value;
        private Entry next;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {
        }

    }

    private Entry[] entries = null;

    /** Initialize your data structure here. */
    public MyHashMap() {
        entries = new Entry[capcity];
    }

    private Entry prev = null;

    private int idx = 0;

    private Entry find(int key) {
        int hash = Objects.hash(key);
        idx = hash & (capcity - 1);
        Entry entry = entries[idx];
        prev = null;
        while( entry != null && entry.key != key) {
            prev = entry;
            entry = entry.next;
        }
        return entry;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Entry entry = find(key);
        if( entry == null) {
            Entry tmp = new Entry(key, value);
            if (entries[idx] != null) {
                tmp.next = entries[idx];
            }
            entries[idx] = tmp;
        } else {
            entry.value = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Entry entry = find(key);
        return entry == null ? -1 : entry.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Entry entry = find(key);
        if( entry != null) {
            if( prev != null) {
                prev.next = entry.next;
            } else {
                entries[idx] = entry.next;
            }
        }
    }

}
