package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 最近的请求次数
 */
public class RecentCounter {

    private Queue<Integer> que = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        while ( !que.isEmpty() && que.peek() < t - 3000) {
            que.poll();
        }
        que.offer(t);
        return que.size();
    }

}
