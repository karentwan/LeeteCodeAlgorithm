package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 最大二叉树 二
 */
public class LeetCode998 {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if( root == null) {
            return new TreeNode(val);
        }
        if( val > root.val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }

}
