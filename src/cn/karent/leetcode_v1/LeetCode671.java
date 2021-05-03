package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 二叉树中第二小的节点
 */
public class LeetCode671 {

    private int dfs(TreeNode root, int val) {
        if( root == null) {
            return -1;
        }
        if( root.val > val) {
            return root.val;
        }
        int left = dfs(root.left, val);
        int right = dfs(root.right, val);
        if( left > val && right > val) {
            return Math.min(left, right);
        }
        return Math.max(left, right);
    }

    public int findSecondMinimumValue(TreeNode root) {
        if( root == null) {
            return -1;
        }
        return dfs(root, root.val);
    }

}
