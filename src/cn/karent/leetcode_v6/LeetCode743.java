package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 网络延迟时间
 * @author wan
 * @date 2021.08.02
 ***********************************************/
public class LeetCode743 {

    private int min(int[] dis, boolean[] vis) {
        int idx = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < dis.length; i++) {
            if( !vis[i] && dis[i] < min ) {
                min = dis[i];
                idx = i;
            }
        }
        return idx;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] edges = new int[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            Arrays.fill(edges[i], Integer.MAX_VALUE);
        }
        int[] dis = new int[n+1];
        boolean[] vis = new boolean[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int[] time : times) {
            edges[time[0]][time[1]] = time[2];
            if( time[0] == k) {
                dis[time[1]] = time[2];
            }
        }
        vis[k] = true;
        int ret = -1;
        int idx = -1;
        int cnt = 1;
        while ((idx = min(dis, vis)) != -1) {
            int d = dis[idx];
            vis[idx] = true;
            ret = d;
            cnt++;
            for (int i = 1; i <= n; i++) {
                if( !vis[i] && edges[idx][i] != Integer.MAX_VALUE && edges[idx][i] + d < dis[i]) {
                    dis[i] = edges[idx][i] + d;
                }
            }
        }
        return cnt == n ? ret : -1;
    }

    public static void main(String[] args) {
        LeetCode743 lc = new LeetCode743();
//        int[][] arr = {{2,1,1},{2,3,1},{3,4,1}};
//        int n = 4;
//        int k = 2;
//        int[][] arr = {{1,2,1},{2,1,3}};
//        int n = 2;
//        int k = 2;
        int[][] arr = {{1,2,1},{2,3,2},{1,3,4}};
        int n = 3;
        int k = 1;
//        int[][] arr = {{1,2,1},{2,3,2},{1,3,1}};
//        int n = 3;
//        int k = 2;
        int ret = lc.networkDelayTime(arr, n, k);
        System.out.println(ret);
    }

}
