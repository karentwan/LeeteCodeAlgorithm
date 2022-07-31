package cn.karent.leetcode_v1.weeklycontest304;

import java.util.*;

/******************************************
 * 图中的最长环
 * @author wan
 * @date 2022.07.31 11:14
 ******************************************/
public class LeetCode6135 {

    public int longestCycle(int[] edges) {
        // 1. 先使用拓扑排序消除环, 剩余的再求环的长度
        int[] indegree = new int[edges.length];
        LinkedList<Integer> st = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] >= 0)
                indegree[edges[i]]++;
        }
        for (int i = 0; i < edges.length; i++) {
            if (indegree[i] == 0) st.offerLast(i);
        }
        // 消除不是环的元素
        while (!st.isEmpty()) {
            Integer node = st.pollLast();
            if (edges[node] >= 0) {
                indegree[edges[node]]--;
                if (indegree[edges[node]] == 0) st.offerLast(edges[node]);
                edges[node] = -1;
            }
        }
        // 求出最长环
        int ret = -1;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {
                // 第一个环长度
                int cnt = 0;
                int j = i;
                while (true) {
                    cnt++;
                    if (edges[j] == i) {  // 环结束
                        edges[j] = -1;
                        break;
                    }
                    int t = j;
                    j = edges[j];
                    edges[t] = -1;
                }
                ret = Math.max(ret, cnt);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6135 lc = new LeetCode6135();
//        int[] edges = {3, 3, 4, 2, 3};
        int[] edges = {2,-1,3,1};
        System.out.println(lc.longestCycle(edges));
    }

}
