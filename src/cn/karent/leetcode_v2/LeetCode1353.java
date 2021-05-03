package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 最多可以参加的会议数目
 */
public class LeetCode1353 {

/*
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (k1, k2) -> {
           if( k1[1] == k2[1]) {
               return k1[0] - k2[0];
           }
           return k1[1] - k2[1];
        });
        int ret = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] event : events) {
            for (int i = event[0]; i <= event[1]; i++) {
                if( !set.contains(i)) {
                    set.add(i);
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }

  */

    // 有点像分配-收集类排序算法
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> que = new PriorityQueue<>((k1, k2) -> {
            return events[k1][1] - events[k2][1];
        });
        final int N = 100010;
        List<Integer>[] in = new List[N];
        for (int i = 0; i < N; i++) {
            in[i] = new ArrayList<>();
        }
        int maxEndDay = 0;
        for (int i = 0; i < events.length; i++) {
            int start = events[i][0];
            int end = events[i][1];
            maxEndDay = Math.max(maxEndDay, end);
            in[start].add(i);
        }
        int ret = 0;
        for (int i = 1; i <= maxEndDay; i++) {
            // 将同一天开始的会议全部加入优先队列
            for (int j = 0; j < in[i].size(); j++) {
                int idx = in[i].get(j);
                que.offer(idx);
            }
            // 将当天已经开完的会议全部剔除
            while (!que.isEmpty() && events[que.peek()][1] < i) {
                que.poll();
            }
            if( !que.isEmpty()) {
                ret++;
                que.poll();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1353 lc = new LeetCode1353();
//        int[][] events = {{1,2},{2,3},{3,4}};
//        int[][] events = {{1,2},{2,3},{3,4},{1,2}};
//        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
        int[][] events = {{1,5},{1,5},{1,5},{2,3},{2,3}};
        int ret = lc.maxEvents(events);
        System.out.println(ret);
    }

}
