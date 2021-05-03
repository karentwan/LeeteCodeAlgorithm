package cn.karent.leetcode;

import java.util.*;

/**
 * LFU缓存 最不经常使用 least frequent use
 */
public class LFUCache {

    class Node {
        private int key;
        private int value;
        private int used;  // 使用次数
        private Node prev;
        private Node next;

        public Node() {
            prev = null;
            next = null;
            used = 1;
        }

        public Node(int key, int value) {
            this();
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key &&
                    value == node.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

    }

    private int capacity;

    private int cnt;

    // 链表从头到尾是按照使用顺序从小到大排序, tail指向的是使用次数最多的节点
    private Node head;

    private Node tail;

    private Map<Integer, Node> map = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cnt = 0;
    }

    private void remove(Node node) {
        // 断开
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    // 将node插入到pos后面
    private void insert(Node node, Node pos) {
        Node prev = pos.prev;
        prev.next = node;
        node.prev = prev;
        node.next = pos;
        pos.prev = node;
    }

    private void adjust(Node node) {
        // 开始调整
        Node next = node.next;
        // 找到要交换的那个元素
        while( next != tail && node.used >= next.used) {
            next = next.next;
        }
        remove(node);
        // 插入
        insert(node, next);
    }

    public int get(int key) {
        Node node = map.getOrDefault(key, null);
        if( node == null) {
            return -1;
        }
        node.used++;
        adjust(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.getOrDefault(key, null);
        if( node != null) {
            node.used++;
            node.value = value;
            adjust(node);
        } else {
            node = new Node(key, value);
            // 如果键不存在则插入
            if( cnt == capacity) {  // 容量满了, 删除节点
                if( map.containsKey(head.next.key)) {
                    map.remove(head.next.key);
                }
                if( head.next != tail) {
                    remove(head.next);
                }
                if( cnt > 0)
                    cnt--;
            }
            if( cnt < capacity) {
                map.put(key, node);
                insert(node, head.next);
                adjust(node);
                cnt++;
            }
        }
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        LFUCache lfu = new LFUCache(1);
        lfu.put(2,1);
        int ret = lfu.get(2);
        System.out.println(ret);
        lfu.put(3,2);
        ret = lfu.get(2);
        System.out.println(ret);
        ret = lfu.get(3);
        System.out.println(ret);
    }

    private static void test2() {
        LFUCache lfu = new LFUCache(0);
        lfu.put(0, 0);
        int ret = lfu.get(0);
        System.out.println(ret);
    }

    private static void test1() {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1,1);
        lfu.put(2,2);
        int ret = lfu.get(1);
        System.out.println(ret);
        lfu.put(3,3);
        ret = lfu.get(2);
        System.out.println(ret);
        ret = lfu.get(3);
        System.out.println(ret);
        lfu.put(4,4);
        ret = lfu.get(1);
        System.out.println(ret);
        ret = lfu.get(3);
        System.out.println(ret);
        ret = lfu.get(4);
        System.out.println(ret);
    }
}
