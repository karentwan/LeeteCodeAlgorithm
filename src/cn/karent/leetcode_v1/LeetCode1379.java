package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 找出克隆二叉树中的相同节点
 */
public class LeetCode1379 {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if( cloned == null) {
            return null;
        }
        if( original == target && cloned.val == target.val) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if( left != null) {
            return left;
        }
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return right;
    }



}
