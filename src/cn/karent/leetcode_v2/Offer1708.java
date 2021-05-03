package cn.karent.leetcode_v2;

import java.util.*;

import cn.karent.util.*;


/**
 * 马戏团人塔
 * @author wan
 * @date 2021.04.05
 */
public class Offer1708 {

/*
    class Node implements Comparable<Node>{
        private int h;
        private int w;

        public Node(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return h == o.h ? o.w - w : o.h - h;
        }

        public boolean compare(Node o) {
            return h < o.h && w < o.w;
        }
    }

    // 超时
    public int bestSeqAtIndex(int[] height, int[] weight) {
        Node[] nodes = new Node[height.length];
        for (int i = 0; i < height.length; i++) {
            nodes[i] = new Node(height[i], weight[i]);
        }
        Arrays.sort(nodes);
        int[] dp = new int[height.length];
        dp[0] = 1;
        int ret = 0;
        for (int i = 1; i < height.length; i++) {
            dp[i] = 1;
            Node cur = nodes[i];
            for (int j = 0; j < i; j++) {
                Node prev = nodes[j];
                if( cur.compare(prev) ) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

*/


    class Node implements Comparable<Node>{
        private int h;
        private int w;

        public Node(int h, int w) {
            this.h = h;
            this.w = w;
        }

        /**
         * 身高升序排序, 体重降序排序
         * @param o
         * @return
         */
        @Override
        public int compareTo(Node o) {
            return h == o.h ? o.w - w : h - o.h;
        }

        public boolean compare(Node o) {
            return h > o.h && w > o.w;
        }
    }

    private int binarySearch(int[] arr, int left, int right, int key) {
        while ( left < right) {
            int mid = left + (right - left) / 2;
            if( arr[mid] >= key) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    // 超时
    public int bestSeqAtIndex(int[] height, int[] weight) {
        Node[] nodes = new Node[height.length];
        for (int i = 0; i < height.length; i++) {
            nodes[i] = new Node(height[i], weight[i]);
        }
        Arrays.sort(nodes);
        int[] dp = new int[height.length];
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            Node node = nodes[i];
            int idx = binarySearch(dp, 0, ret, node.w);
            dp[idx] = node.w;
            if( idx == ret) {
                ret++;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
//        int[] height = {65,70,56,75,60,68};
//        int[] weight = {100,150,90,190,95,110};
        int[] height = {5401,9628,3367,6600,6983,7853,5715,2654,4453,8619};
        int[] weight = {3614,1553,2731,7894,8689,182,7632,4465,8932,4304};
        Offer1708 offer = new Offer1708();
        int ret = offer.bestSeqAtIndex(height, weight);
        System.out.println(ret);
    }

}
