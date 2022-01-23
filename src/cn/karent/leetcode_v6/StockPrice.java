package cn.karent.leetcode_v6;

import java.util.*;

/**
 * 股票价格波动
 * TreeSet和TreeMap不支持更新操作, 但是更新操作 = 删除操作 + 插入操作
 */
public class StockPrice {

    private int maxTimestamp;

    private Map<Integer, Integer> map = new HashMap<>();

    private TreeMap<Integer, Integer> prices = new TreeMap<>();

    public StockPrice() { }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        if (map.containsKey(timestamp)) {
            int prev = map.get(timestamp);
            Integer val = prices.get(prev);
            if (val == 1) {
                prices.remove(prev);
            } else {
                prices.put(prev, val-1);
            }
        }
        Integer newVal = prices.getOrDefault(price, 0);
        prices.put(price, newVal+1);
        map.put(timestamp, price);
    }

    public int current() {
        return map.get(maxTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }

    public static void main(String[] args) {
        StockPrice lc = new StockPrice();
        lc.update(1, 10);
        lc.update(2,5);
        System.out.println(lc.current());
        System.out.println(lc.maximum());
        lc.update(1, 3);
        System.out.println(lc.maximum());
        lc.update(4,2);
        System.out.println(lc.minimum());
    }


}
