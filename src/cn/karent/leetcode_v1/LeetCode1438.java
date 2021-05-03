package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 绝对差不超过限制的最长连续子数组
 */
public class LeetCode1438 {

    private boolean valid(int[] nums, int i, int j, int limit) {
        while( i < j) {
            if( Math.abs(nums[i] - nums[j]) > limit) {
                return false;
            }
            i++;
        }
        return true;
    }

    // 超时
    public int longestSubarray1(int[] nums, int limit) {
        int i = 0, j = 0;
        int ret = 0;
        while( j < nums.length ) {
            while( !valid(nums, i, j, limit)) {
                i++;
            }
            j++;
            ret = Math.max(ret, j - i);
        }
        return ret;
    }

    class Node implements Comparable<Node>{

        private int idx;
        private int val;

        @Override
        public int compareTo(Node o) {
            if( val == o.val) {
                return idx - o.idx;
            }
            return val - o.val;
        }

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    // 使用插入有序集合, 可以快速得到一个窗口内最大和最小元素, 方便
    public int longestSubarray(int[] nums, int limit) {
        int i = 0, j = 0;
        int ret = 0;
        TreeSet<Node> treeSet = new TreeSet<>();
        while( j < nums.length ) {
            treeSet.add(new Node(j, nums[j]));
            Node low = treeSet.first();
            Node high = treeSet.last();
            if( high.val - low.val <= limit) {
                ret = Math.max(ret, j - i + 1);
            } else {
                treeSet.remove(new Node(i, nums[i]));
                i++;
            }
            j++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1438 lc = new LeetCode1438();
//        int[] nums = {8,2,4,7};
//        int limit = 4;
//        int[] nums = {10,1,2,4,7,2};
//        int limit = 5;
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        int ret = lc.longestSubarray(nums, limit);
        System.out.println(ret);
    }
    
}
