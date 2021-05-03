package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 删除给定值的叶子节点
 */
public class LeetCode1325 {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if( root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if( root.left == null && root.right == null &&  root.val == target) {
            return null;
        }
        return root;
    }

}
