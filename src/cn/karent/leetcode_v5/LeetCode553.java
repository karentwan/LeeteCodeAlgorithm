package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 最优除法
 * @author wan
 * @date 2021.06.28
 ***********************************************/
public class LeetCode553 {

    class Node {
        float min_val;
        float max_val;
        String min_str;
        String max_str;

        public Node() {
            min_val = Float.MAX_VALUE;
            max_val = Float.MIN_VALUE;
        }

        public Node(float min_val, float max_val, String min_str, String max_str) {
            this.min_val = min_val;
            this.max_val = max_val;
            this.min_str = min_str;
            this.max_str = max_str;
        }

    }

    private Node dfs(int[] nums, int s, int e) {
        if( s == e) {
            return new Node(nums[s], nums[s],
                    String.valueOf(nums[s]), String.valueOf(nums[s]));
        }
        Node ret = new Node();
        for (int i = s; i < e; i++) {
            Node left = dfs(nums, s, i);
            Node right = dfs(nums, i+1, e);
            if(  ret.min_val > left.min_val / right.max_val) {
                ret.min_val = left.min_val / right.max_val;
                ret.min_str = left.min_str + "/" +
                        ((right.max_str.indexOf("/") == -1) ? right.max_str : "(" + right.max_str + ")");
            }
            if(  ret.max_val < left.max_val / right.min_val) {
                ret.max_val = left.max_val / right.min_val;
                ret.max_str = left.max_str + "/" + ((right.min_str.indexOf("/") == -1) ? right.min_str :
                        "(" + right.min_str + ")");
            }
        }
        return ret;
    }

    public String optimalDivision(int[] nums) {
        if( nums.length == 0) return -1 + "";
        Node ret = dfs(nums, 0, nums.length-1);
        return ret.max_str;
    }

    public static void main(String[] args) {
        LeetCode553 lc = new LeetCode553();
//        int[] arr = {1000, 100, 10, 2};
//        int[] arr = {1000, 100, 10, 2};
//        int[] arr = {2,3,4};
        int[] arr = {6,2,3,4,5};
        String ret = lc.optimalDivision(arr);
        System.out.println(ret);
    }

}
