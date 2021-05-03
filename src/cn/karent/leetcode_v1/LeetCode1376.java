package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 通知所有员工所需的时间
 */
public class LeetCode1376 {


  /*  // 超时
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int ret = informTime[headID];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if( manager[i] == headID) {
                max = Math.max(max, numOfMinutes(n, i, manager, informTime));
            }
        }
        return ret + max;
    }*/

    private int dfs(List<List<Integer>> edges, int idx, int[] informTime) {
        List<Integer> edge = edges.get(idx);
        int ret = 0;
        for (Integer e : edge) {
            ret = Math.max(ret, dfs(edges, e, informTime));
        }
        return ret + informTime[idx];
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if( manager[i] == -1) {
                continue;
            }
            edges.get(manager[i]).add(i);
        }
        return dfs(edges, headID, informTime);
    }

    public static void main(String[] args) {
        LeetCode1376 lc = new LeetCode1376();
//        int n = 1;
//        int headId = 0;
//        int[] manager = {-1};
//        int[] informTime = {0};
//        int n = 6;
//        int headId = 2;
//        int[] manager = {2,2,-1,2,2,2};
//        int[] informTime = {0,0,1,0,0,0};
        int n = 15;
        int headId = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        int ret = lc.numOfMinutes(n, headId, manager, informTime);
        System.out.println(ret);
    }

}
