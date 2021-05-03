package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 二叉搜索树的范围和
 */
public class LeetCode938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if( root == null) {
            return 0;
        }
        int val = root.val;
        int ret = 0;
        if( val >= low && val <= high) {
            ret += val;
        }
        ret += rangeSumBST(root.left, low, high);
        ret += rangeSumBST(root.right, low, high);
        return ret;
    }

    public static void main(String[] args) {
        Integer[] arr = {10,5,15,3,7,null,18};
        int low = 7;
        int high = 15;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        LeetCode938 lc = new LeetCode938();
        int ret = lc.rangeSumBST(root, low, high);
        System.out.println(ret);
    }

}
