package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 吃苹果的最大数目
 * @author wan
 * @date 2021.04.29
 ********************************************/
public class LeetCode1705 {

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((k1, k2) -> k1[1] - k2[1]);
        int ret = 0;
        int i = 0;
        for (i = 0; i < apples.length; i++) {
            if( apples[i] > 0 && days[i] > 0)
                pq.offer(new int[]{apples[i], i + days[i]});
            while (!pq.isEmpty() && pq.peek()[1] <= i)
                pq.poll();
            if( !pq.isEmpty()) {
                int[] tmps = pq.poll();
                if( tmps[0] > 0) {
                    ret++;
                    tmps[0]--;
                    if( tmps[0] > 0 ) {
                        pq.offer(tmps);
                    }
                }
            }
        }
        while (!pq.isEmpty()) {
            int[] tmps = pq.poll();
            int next = Math.max(Math.min(tmps[0], tmps[1] - i), 0);
            ret += next;
            i += next;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1705 lc = new LeetCode1705();
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
//        int[] apples = {3,0,0,0,0,2};
//        int[] days = {3,0,0,0,0,2};
//        int[] apples = {3,1,1,0,0,2};
//        int[] days = {3,1,1,0,0,2};
        int ret = lc.eatenApples(apples, days);
        System.out.println(ret);
    }

}
