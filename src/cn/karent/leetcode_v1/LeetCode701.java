package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 二叉搜索树中的插入操作
 */
public class LeetCode701 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if( root == null) {
            return new TreeNode(val);
        }
        if( root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

}
