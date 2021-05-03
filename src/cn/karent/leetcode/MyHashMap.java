package cn.karent.leetcode;

/**
 * 设计哈希映射 LeetCode706
 */
public class MyHashMap {

    class Entry {
        int key = 0;
        int value = 0;
        Entry next = null;

        public Entry(){}

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] data = null;

    private int capcity = 64;

    /** Initialize your data structure here. */
    public MyHashMap() {
        data = new Entry[capcity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = key % capcity;
        if( data[idx] == null) {
            data[idx] = new Entry(key, value);
        } else {
            Entry p = new Entry(key, value);
            p.next = data[idx];
            data[idx] = p;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = key % capcity;
        Entry p = data[idx];
        while( p != null && p.key != key) {
            p = p.next;
        }
        return p == null ? -1 : p.value;
    }

    private boolean remove_(int key) {
        int idx = key % capcity;
        Entry pre = null;
        Entry p = data[idx];
        while( p != null && p.key != key) {
            pre = p;
            p = p.next;
        }
        if( p == null) {
            return false;
        }
        if( pre != null) {
            pre.next = p.next;
        } else {
            data[idx] = p.next;
        }
        return true;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        while( remove_(key) );
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        int ret = hashMap.get(1);
        System.out.println(ret);
        ret = hashMap.get(3);
        System.out.println(ret);
        hashMap.put(2, 1);
        ret = hashMap.get(2);
        System.out.println(ret);
        hashMap.remove(2);
        ret = hashMap.get(2);
        System.out.println(ret);
    }
}
