package cn.karent.leetcode_v4.weeklycontest239;

import java.util.*;

/********************************************
 * description: 包含每个查询的最小区间
 * @author wan
 * @date 2021.05.03
 ********************************************/
public class Algo5748 {


    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (k1, k2) -> k1[0] - k2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((k1, k2) -> (k1[1] - k1[0]) - (k2[1] - k2[0]));
        int[][] tmps = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            tmps[i][0] = i;
            tmps[i][1] = queries[i];
        }
        Arrays.sort(tmps, (k1, k2) -> k1[1] - k2[1]);
        int i = 0, j = 0;
        int[] rets = new int[queries.length];
        Arrays.fill(rets, -1);
        while ( j < tmps.length) {
            while (i < intervals.length && intervals[i][0] <= tmps[j][1]) {
                pq.offer(intervals[i]);
                i++;
            }
            // 去掉不符合规范的元素
            while (!pq.isEmpty() && pq.peek()[1] < tmps[j][1]) pq.poll();
            if( !pq.isEmpty() ) {
                int[] tmp = pq.peek();
                rets[tmps[j][0]] = tmp[1] - tmp[0] + 1;
            }
            j++;
        }
        return rets;
    }

    public static void main(String[] args) {
        Algo5748 lc = new Algo5748();
//        int[][] intervals = {{1,4},{2,4},{3,6},{4,4}};
//        int[] queries = {2, 3, 4, 5};
        int[][] intervals = {{2,3},{2,5},{1,8},{20,25}};
        int[] queries = {2,19,5,22};
        int[] rets = lc.minInterval(intervals, queries);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
