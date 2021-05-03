package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 二叉搜索树中的搜索
 */
public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if( root == null) {
            return null;
        }
        if( root.val == val) {
            return root;
        } else if( root.val < val) {
            return searchBST(root.right, val);
        }
        return searchBST(root.left, val);
    }

}
