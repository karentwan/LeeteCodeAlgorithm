package cn.karent.leetcode_v3;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 二叉搜索树的范围和
 * @author wan
 * @date 2021.04.27
 ********************************************/
public class LeetCode938 {

    private int ret = 0;

    private void dfs(TreeNode root, int low, int high) {
        if( root == null) return;
        dfs(root.left, low, high);
        if( root.val >= low && root.val <= high) {
            ret += root.val;
        }
        dfs(root.right, low, high);
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode938 lc = new LeetCode938();
//        Integer[] arr = {10, 5, 15, 3, 7, null, 18};
//        int low = 7;
//        int high = 15;
        Integer[] arr = {10,5,15,3,7,13,18,1,null,6};
        int low = 6;
        int high = 10;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.rangeSumBST(root, low, high);
        System.out.println(ret);
    }

}
