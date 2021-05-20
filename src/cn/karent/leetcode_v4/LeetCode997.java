package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 找到小镇法官
 * @author wan
 * @date 2021.05.20
 ********************************************/
public class LeetCode997 {

    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];
        for (int[] item : trust) {
            int a = item[0];
            int b = item[1];
            inDegree[b]++;
            outDegree[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if( inDegree[i] == n-1 && outDegree[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode997 lc = new LeetCode997();
//        int n = 2;
//        int[][] trust = {{1,2}};
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        int ret = lc.findJudge(n, trust);
        System.out.println(ret);
    }

}
