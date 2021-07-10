package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 基于时间的剪枝存储
 * @author wan
 * @date 2021.07.10
 ***********************************************/
public class TimeMap {

    class Node {
        String value;
        int time;

        public Node(String value, int time) {
            this.value = value;
            this.time = time;
        }
    }

    private Map<String, List<Node>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if( !map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        List<Node> values = map.get(key);
        values.add(new Node(value, timestamp));
    }

    private int lt(List<Node> values, int timestemp) {
        int l = 0, r = values.size()-1;
        while ( l <= r) {
            int m = l + (r - l)/2;
            if( values.get(m).time >= timestemp) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return l < values.size() && values.get(l).time == timestemp ? l : r;
    }

    public String get(String key, int timestamp) {
        if( !map.containsKey(key)) return "";
        List<Node> values = map.get(key);
        int idx = lt(values, timestamp);
        if( idx < values.size()) return values.get(idx).value;
        return "";
    }

    public static void main(String[] args) {
        TimeMap lc = new TimeMap();
        lc.set("foo", "bar", 1);
        System.out.println(lc.get("foo", 1));
        System.out.println(lc.get("foo", 3));
        lc.set("foo", "bar2", 4);
        System.out.println(lc.get("foo", 4));
        System.out.println(lc.get("foo", 5));
    }

}
