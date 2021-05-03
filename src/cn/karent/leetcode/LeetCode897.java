package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 递增顺序查找树
 */
public class LeetCode897 {

    private TreeNode root = null;

    private TreeNode prev = null;

    private void dfs(TreeNode root) {
        if( root == null) {
            return;
        }
        dfs(root.left);
        root.left = null;
        if( prev == null) {
            this.root = root;
        } else {
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        dfs(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return this.root;
    }

}
