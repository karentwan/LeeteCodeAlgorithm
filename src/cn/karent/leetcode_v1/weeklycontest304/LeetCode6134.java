package cn.karent.leetcode_v1.weeklycontest304;

import java.util.*;

/******************************************
 * 找到离给定两个节点最近的节点
 * @author wan
 * @date 2022.07.31 10:54
 ******************************************/
public class LeetCode6134 {

    private void calcDistance(int[] edges, int node, int[] dis) {
        int p = node;
        boolean[] vis = new boolean[edges.length];
        vis[p] = true;
        int cnt = 0;
        while (true) {
            dis[p] = cnt;
            p = edges[p];
            if (p != -1 && !vis[p]) {
                vis[p] = true;
            } else {
                break;
            }
            cnt++;
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // 单源节点距离最小值, 迪杰斯特拉算法
        int[] node1Dis = new int[edges.length];
        int[] node2Dis = new int[edges.length];
        calcDistance(edges, node1, node1Dis);
        calcDistance(edges, node2, node2Dis);
        int ret = Integer.MAX_VALUE, node = -1;
        for (int i = 0; i < edges.length; i++) {
            if ((node1Dis[i] == 0 && node1 != i) ||
            (node2Dis[i] == 0 && node2 != i)) continue;
            int t = Math.max(node1Dis[i], node2Dis[i]);
            if (t < ret) {
                ret = t;
                node = i;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        LeetCode6134 lc = new LeetCode6134();
        int[] edges = {2, 2, 3, -1};
        int node1 = 0;
        int node2 = 1;
        System.out.println(lc.closestMeetingNode(edges, node1, node2));
    }

}
