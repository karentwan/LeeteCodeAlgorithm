package cn.karent.leetcode_v3.weeklycontest237;

import java.util.*;

/**
 * 单线程CPU
 * @author wan
 * @date 2021.04.18
 */
public class Algo5736 {

    class Node {
        private int start;
        private int dura;
        private int idx;

        public Node(int start, int dura, int idx) {
            this.start = start;
            this.dura = dura;
            this.idx = idx;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int i = 0;
        int n = tasks.length;
        int[] rets = new int[n];
        if( n == 0) return rets;
        int k = 0;
        Node[] nodes = new Node[n];
        for (int j = 0; j < tasks.length; j++) {
            nodes[j] = new Node(tasks[j][0], tasks[j][1], j);
        }
        Arrays.sort(nodes, (k1, k2) -> k1.start - k2.start);
        int endTime = nodes[0].start;
        PriorityQueue<Node> pq = new PriorityQueue<>((k1, k2) -> k1.dura == k2.dura ?
                k1.idx - k2.idx : k1.dura - k2.dura);
        while (i < n) {
            int time = nodes[i].start;
            while (endTime < time && !pq.isEmpty()) {
                Node node = pq.poll();
                rets[k++] = node.idx;
                endTime += node.dura;
            }
            // 将同一个时间开始的入队
            pq.offer(nodes[i]);
            int j = i+1;
            while (j < n && nodes[j].start == nodes[i].start) {
                pq.offer(nodes[j]);
                j++;
            }
            i = j;
        }
        while (!pq.isEmpty()) rets[k++] = pq.poll().idx;
        return rets;
    }


 /*   public int[] getOrder(int[][] tasks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (k1, k2) -> tasks[k1][1] == tasks[k2][1] ?
                        tasks[k1][0] - tasks[k2][0] : tasks[k1][1] - tasks[k2][1]);
        int i = 0;
        int n = tasks.length;
        int[] rets = new int[n];
        int k = 0;
        int endTime = 0;
        Integer[] indices = new Integer[n];
        for (int j = 0; j < n; j++) {
            indices[j] = j;
        }
        Arrays.sort(indices, (k1, k2) -> tasks[k1][0] - tasks[k2][0]);
        while (i < n) {
            int realI = indices[i];
            int time = tasks[realI][0];
            while (endTime < time && !pq.isEmpty()) {
                int idx = pq.poll();
                rets[k++] = idx;
                endTime = tasks[idx][0] + tasks[idx][1];
            }
            // 将同一个时间开始的入队
            pq.offer(realI);
            int j = i+1;
            while (j < n && tasks[indices[j]][0] == tasks[realI][0]) {
                pq.offer(indices[j]);
                j++;
            }
            i = j;
        }
        while (!pq.isEmpty()) rets[k++] = pq.poll();
        return rets;
    }*/

    public static void main(String[] args) {
        Algo5736 lc = new Algo5736();
//        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
//        int[][] tasks = {{7,10},{7,12},{7,5},{7,4},{7,2}};
        int[][] tasks = {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}};
        int[] rets = lc.getOrder(tasks);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
