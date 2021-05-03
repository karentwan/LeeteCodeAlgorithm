package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 检查树的平衡性
 */
public class Offer0404 {

    private int[] dfs(TreeNode root) {
        if( root == null) {
            return new int[]{1, 1};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] ret = new int[2];
        ret[0] = left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1? 1 : -1;
        ret[1] = Math.max(left[1], right[1]) + 1;
        return ret;
    }

    public boolean isBalanced(TreeNode root) {
        int[] ret = dfs(root);
        return ret[0] == 1;
    }

    public static void main(String[] args) {
        Offer0404 offer = new Offer0404();
        Integer[] arr = {1,2,2,3,3,null,null,4,4};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        boolean ret = offer.isBalanced(root);
        System.out.println(ret);
    }

}
