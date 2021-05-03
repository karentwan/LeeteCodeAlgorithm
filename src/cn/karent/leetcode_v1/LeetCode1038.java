package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 把二叉搜索树转换为累加树
 */
public class LeetCode1038 {

    private int dfs(TreeNode root, int val) {
        if( root == null) {
            return 0;
        }
        int right = dfs(root.right, val);
        int t = right + root.val;
        root.val = t + val;
        return t + dfs(root.left, t + val);
    }

    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public static void main(String[] args) {
        LeetCode1038 lc = new LeetCode1038();
        Integer[] arr = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        LeetCodeUtil.levelTraverse(root);
        root = lc.bstToGst(root);
        System.out.println("============================");
        LeetCodeUtil.levelTraverse(root);
    }

}
