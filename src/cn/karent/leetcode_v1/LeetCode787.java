package cn.karent.leetcode_v1;

import java.util.*;

/**
 * k站中转内最便宜的航班
 */
public class LeetCode787 {

    class Node {
        private int vertex;
        private int cost;
        private int k;

        public Node(int vertex, int cost, int k) {
            this.vertex = vertex;
            this.cost = cost;
            this.k = k;
        }
    }

    // 使用迪杰斯特拉算法来求最短路径
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((k1, k2) -> {
            return k1.cost - k2.cost;
        });
//        Map<Integer, Integer> best = new HashMap<>();
        // 如果使用这个会因为步长而到不了
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);
        pq.offer(new Node(src, 0, 0));
        while( !pq.isEmpty() ) {
            Node node = pq.poll();
            if( node.vertex == dst ) {
                return node.cost;
            }
            // 如果当前节点已经中转了K次, 那么就不用再中转了, 因为后面的一定大于K, 不符合要求
            if( node.k >= K+1) {
                continue;
            }
            for (int i = 0; i < n; i++) {
                if( graph[node.vertex][i] > 0) {
                    int newCost = node.cost + graph[node.vertex][i];
//                    if( newCost < best.getOrDefault((node.k+1) * 1000 + i, Integer.MAX_VALUE)) {
//                    if( newCost < best.getOrDefault(i, Integer.MAX_VALUE)) {
                    if( newCost < best[i]) {
                        pq.offer(new Node(i, newCost, node.k+1));
//                        best.put((node.k+1)*1000+i, newCost);
                        best[i] = newCost;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode787 lc = new LeetCode787();
//        int n = 3;
//        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
//        int src = 0;
//        int dst = 2;
//        int k = 1;
        int n = 5;
        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int src = 0;
        int dst = 2;
        int k = 2;
        int ret = lc.findCheapestPrice(n, flights, src, dst, k);
        System.out.println(ret);
    }

}
