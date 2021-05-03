package cn.karent.leetcode_v1;

import java.util.Objects;

/**
 * 设计哈希集合
 */
public class MyHashSet {

    private int capcity = 64;

    class Entry {
        private int key;
        private Entry next;

        public Entry(int key, Entry next) {
            this.key = key;
            this.next = next;
        }

        public Entry(int key) {
            this.key = key;
        }
    }

    private Entry[] entries = null;

    /** Initialize your data structure here. */
    public MyHashSet() {
        entries = new Entry[capcity];
    }

    private Entry prev = null;

    private int idx = 0;

    private Entry find(int key) {
        int hash = Objects.hash(key);
        idx = hash % capcity;
        Entry entry = entries[idx];
        while( entry != null && entry.key != key) {
            prev = entry;
            entry = entry.next;
        }
        return entry;
    }

    public void add(int key) {
        prev = null;
        Entry entry = find(key);
        if( entry == null) {
            if( prev == null) {
                entries[idx] = new Entry(key);
            } else {
                prev.next = new Entry(key);
            }
        }
    }

    public void remove(int key) {
        prev = null;
        Entry entry = find(key);
        if( entry != null) {
            if( prev == null) {
                entries[idx] = entries[idx].next;
            } else {
                prev.next = entry.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        prev = null;
        Entry entry = find(key);
        while( entry != null && entry.key != key) {
            prev = entry;
            entry = entry.next;
        }
        return entry != null;
    }

    public static void main(String[] args) {
        MyHashSet mhs = new MyHashSet();
        mhs.add(1);
        mhs.add(2);
        System.out.println(mhs.contains(1));
        System.out.println(mhs.contains(3));
        mhs.add(2);
        System.out.println(mhs.contains(2));
        mhs.remove(2);
        System.out.println(mhs.contains(2));
    }

}
