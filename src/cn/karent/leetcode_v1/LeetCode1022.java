package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 从根到叶的二进制数之和
 */
public class LeetCode1022 {

    private int ret = 0;

    private void dfs(TreeNode root, int parent) {
        if( root == null) {
            return;
        }
        int base = parent * 2 + root.val;
        if( root.left == null && root.right == null) {  // 叶子节点
            ret += base;
            return;
        }
        dfs(root.left, base);
        dfs(root.right, base);
    }

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return ret;
    }

}
