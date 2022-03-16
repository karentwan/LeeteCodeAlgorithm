package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-03-16 07:56
 * @description: 全O(1)的数据结构
 *******************************************/
public class AllOne {
/*
    // 解法1, 使用哈希套优先队列
    private Map<String, Integer> map = new HashMap<>();

    private PriorityQueue<String> maxpq = new PriorityQueue<>((k1, k2) -> map.get(k2) - map.get(k1));

    private PriorityQueue<String> minpq = new PriorityQueue<>((k1, k2) -> map.get(k1) - map.get(k2));

    public AllOne() {

    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            map.put(key, 1);
            maxpq.offer(key);
            minpq.offer(key);
        } else {
            map.put(key, map.get(key) + 1);
            maxpq.remove(key);
            maxpq.offer(key);
            minpq.remove(key);
            minpq.offer(key);
        }
    }

    public void dec(String key) {
        if (!map.containsKey(key)) return;
        if (map.get(key) == 1) {
            map.remove(key);
            maxpq.remove(key);
            minpq.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
            maxpq.remove(key); maxpq.offer(key);
            minpq.remove(key); minpq.offer(key);
        }

    }

    public String getMaxKey() {
        if (maxpq.isEmpty()) return "";
        return maxpq.peek();
    }

    public String getMinKey() {
        if (minpq.isEmpty()) return "";
        return minpq.peek();
    }
*/

    class Node {
        Node next;
        Node prev;
        int cnt;  // 次数
        Set<String> keys;

        public Node() {
            cnt = 1;
        }

        public Node(String key, int cnt) {
            this.cnt = cnt;
            keys = new HashSet<>();
            keys.add(key);
        }

        public void add(String key) {
            keys.add(key);
        }

        public void remove(String key) {
            keys.remove(key);
        }

        public boolean isEmpty() {
            return keys.isEmpty();
        }

    }

    private Node header;

    private Node tail;

    private Map<String, Node> map;

    // 解法2 双链表加哈希
    public AllOne() {
        header = new Node();
        tail = new Node();
        header.next = tail;
        tail.prev = header;
        map = new HashMap<>();
    }


    public void inc(String key) {
        if (!map.containsKey(key)) {  //
            if (header.next == tail || header.next.cnt > 1) {
                Node node = new Node(key, 1);
                node.next = header.next;
                header.next.prev = node;
                node.prev = header;
                header.next = node;
                map.put(key, node);
            } else {
                header.next.add(key);
                map.put(key, header.next);
            }
        } else {
            Node node = map.get(key);
            if (node.next == tail || node.next.cnt > node.cnt + 1) {
                Node next = new Node(key, node.cnt+1);
                next.next = node.next;
                node.next.prev = next;
                next.prev = node;
                node.next = next;
                map.put(key, next);
            } else {
                node.next.add(key);
                map.put(key, node.next);
            }
            node.remove(key);
            if (node.isEmpty()) {
                remove(node);
            }
        }
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void dec(String key) {
        Node node = map.get(key);
        if (node.cnt == 1) {
            node.remove(key);
            map.remove(key);
        } else {
            if (node.prev == header || node.prev.cnt < node.cnt - 1) {
                Node prev = new Node(key, node.cnt - 1);
                prev.prev = node.prev;
                node.prev.next = prev;
                node.prev = prev;
                prev.next = node;
                map.put(key, prev);
            } else {
                node.prev.add(key);
                map.put(key, node.prev);
            }
            node.remove(key);
        }
        if (node.isEmpty()) {
            remove(node);
        }
    }

    public String getMaxKey() {
        if (tail.prev == header) return "";
        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (tail.prev == header) return "";
        return header.next.keys.iterator().next();
    }

    public static void main(String[] args) {
//        AllOne lc = new AllOne();
//        lc.inc("hello");
//        lc.inc("hello");
//        System.out.println(lc.getMaxKey());
//        System.out.println(lc.getMinKey());
//        lc.inc("leet");
//        System.out.println(lc.getMaxKey());
//        System.out.println(lc.getMinKey());
//        AllOne lc = new AllOne();
//        lc.inc("a");
//        lc.inc("b");
//        lc.inc("b");
//        lc.inc("c");
//        lc.inc("c");
//        lc.inc("c");
//        lc.dec("b");
//        lc.dec("b");
//        System.out.println(lc.getMinKey());
//        lc.dec("a");
//        System.out.println(lc.getMaxKey());
//        System.out.println(lc.getMinKey());

        AllOne lc = new AllOne();
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("a");
        lc.inc("b");
        lc.inc("b");
        lc.inc("b");
        lc.inc("b");
        lc.inc("b");
        lc.inc("b");
        lc.dec("a");
        lc.dec("a");
        lc.dec("a");
        lc.dec("a");
        lc.dec("a");
        System.out.println(lc.getMaxKey());
        System.out.println(lc.getMinKey());

    }

}
