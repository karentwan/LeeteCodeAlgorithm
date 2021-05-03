package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 统计二叉树中好节点的数目
 */
public class LeetCode1448 {

    private int ret;

    private void dfs(TreeNode root, int pre) {
        if( root == null) {
            return ;
        }
        if(root.val >= pre) {
            ret++;
            pre = root.val;
        }
        dfs(root.left, pre);
        dfs(root.right, pre);
    }

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1448 lc = new LeetCode1448();
        Integer[] arr = {3,1,4,3,null,1,5};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.goodNodes(root);
        System.out.println(ret);
    }

}
