package cn.karent.leetcode;

import java.util.*;

/**
 * 最接近原点的k个点
 */
public class LeetCode973 {

    class Node implements Comparable<Node>{
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            int t1 = x * x + y * y;
            int t2 = o.x * o.x + o.y * o.y;
            return t2 - t1;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        // 大顶堆
        PriorityQueue<Node> que = new PriorityQueue<>();
        for (int[] point : points) {
            Node node = new Node(point[0], point[1]);
            if( que.size() < K ) {
                que.offer(node);
            } else if( que.peek().compareTo(node) < 0) {
                que.poll();
                que.offer(node);
            }
        }
        int[][] rets = new int[que.size()][2];
        int i = 0;
        while( !que.isEmpty() ) {
            Node node = que.poll();
            rets[i][0] = node.x;
            rets[i][1] = node.y;
            i++;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode973 lc = new LeetCode973();
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
//        int[][] points = {{3,3},{5,-1},{-2,4}};
//        int k = 2;
        int[][] rets = lc.kClosest(points, k);
        for (int[] ret : rets) {
            System.out.println("(" + ret[0] + "," + ret[1] + ")");
        }
    }
}
