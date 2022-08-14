package cn.karent.leetcode_v7.weeklycontest306;

import java.util.*;

/******************************************
 * 边积分最高的节点
 * @author wan
 * @date 2022.08.14 10:43
 ******************************************/
public class LeetCode6149 {

    public int edgeScore(int[] edges) {
        long[] tmps = new long[edges.length];
        for (int i = 0; i < edges.length; i++) {
            tmps[edges[i]] += i;
        }
        long max = 0;
        int ret = 0;
        for (int i = 0; i < edges.length; i++) {
            if (tmps[i] > max) {
                max = tmps[i];
                ret = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6149 lc = new LeetCode6149();
        int[] edges = {2,0,0,2};
        System.out.println(lc.edgeScore(edges));
    }

}
