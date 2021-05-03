package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 单值二叉树
 */
public class LeetCode965 {

    private boolean dfs(TreeNode root, int val) {
        if( root == null) {
            return true;
        }
        if( root.val != val) {
            return false;
        }
        return dfs(root.left, val) && dfs(root.right, val);
    }

    public boolean isUnivalTree(TreeNode root) {
        if( root == null) {
            return true;
        }
        return dfs(root, root.val);
    }

}
