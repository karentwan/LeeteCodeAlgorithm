package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 在二叉树中分配硬币
 */
public class LeetCode979 {

    private int ret = 0;

    private void dfs(TreeNode root) {
        if( root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        int t = 0;
        int shift = 0;
        if( root.left != null) {
            t = root.left.val - 1;
            root.val += t;
            shift = Math.abs(t);
        }
        if( root.right != null) {
            t = root.right.val - 1;
            root.val += t;
            shift += Math.abs(t);
        }
        ret += shift;
    }

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode979 lc = new LeetCode979();
//        Integer[] arr = {0,3,0};
        Integer[] arr = {1,0,2};
//        Integer[] arr = {1,0,0,null,3};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.distributeCoins(root);
        System.out.println(ret);
    }

}
