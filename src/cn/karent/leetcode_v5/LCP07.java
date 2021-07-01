package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 传递信息
 * @author wan
 * @date 2021.07.01
 ***********************************************/
public class LCP07 {

    public int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            edges.get(edge[0]).add(edge[1]);
        }
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        while (!que.isEmpty() && k > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int e = que.poll();
                List<Integer> edge = edges.get(e);
                for (Integer e1 : edge) {
                    que.offer(e1);
                }
            }
            k--;
        }
        int ret = 0;
        while (!que.isEmpty()) {
            int e = que.poll();
            if( e == n-1) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LCP07 lc = new LCP07();
        int n = 5;
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        int k = 3;
        int ret = lc.numWays(n, relation, k);
        System.out.println(ret);
    }

}
