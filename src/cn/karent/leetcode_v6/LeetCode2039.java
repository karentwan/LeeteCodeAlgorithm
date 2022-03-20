package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-03-20 09:20
 * @description: 网络空闲的时刻
 *******************************************/
public class LeetCode2039 {

    // 用一个BFS就可以了, 不需要使用迪杰斯特拉算法
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;  // 节点个数
        // 定义边
        List<List<Integer>> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edgeList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge[1]);
            edgeList.get(edge[1]).add(edge[0]);
        }
        LinkedList<Integer> que = new LinkedList<>();
        int ret = 0, level = 0;
        Set<Integer> vis = new HashSet<>();
        que.offer(0);
        vis.add(0);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int node = que.poll();
                int patient = patience[node];  // 等待值
                int second = level * 2;
                second = (int)((second - 0.5) / patient) * patient + second;
                ret = Math.max(second + 1, ret);
                for (Integer e : edgeList.get(node)) {
                    if (!vis.contains(e)) {
                        que.offer(e);
                        vis.add(e);
                    }
                }
            }
            level++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode2039 lc = new LeetCode2039();
//        int[][] edges = {{0,1},{1,2}};
//        int[] patience = {0,2,1};
        int[][] edges = {{0,1},{0,2},{1,2}};
        int[] patience = {0,10,10};
        System.out.println(lc.networkBecomesIdle(edges, patience));
    }

}
