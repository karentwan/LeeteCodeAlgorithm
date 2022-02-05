package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 随机翻转矩阵
 * @author wan
 * @date 2021.11.27
 ***********************************************/
public class LeetCode319 {

    private int total, m, n;

    private Map<Integer, Integer> map = new HashMap<>();

    private Random random = new Random();

    public LeetCode319(int m, int n) {
        this.m = m; this.n = n;
        this.total = m * n;
    }

    public int[] flip() {
        int x = random.nextInt(total);
        total--;
        int idx = map.getOrDefault(x, x);
        // 交换
        map.put(x, map.getOrDefault(total, total));
        return new int[]{idx / n, idx % n};
    }

    public void reset() {
        total = m * n;
        map.clear();
    }

    public static void main(String[] args) {

    }

}
