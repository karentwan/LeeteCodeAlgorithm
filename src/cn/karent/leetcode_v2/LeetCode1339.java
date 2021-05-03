package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 分裂二叉树的最大乘积
 */
public class LeetCode1339 {

    private long sum;

    private void sumAllNode(TreeNode root) {
        if (root == null) {
            return;
        }
        sum += root.val;
        sumAllNode(root.left);
        sumAllNode(root.right);
    }

    private long ret = 0;

    private long split(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long left = split(root.left);
        long right = split(root.right);
        long tmp = Math.max((sum - left) * left, (sum - right) * right);
        ret = Math.max(ret, tmp);
        return left + right + root.val;
    }

    public int maxProduct(TreeNode root) {
        sumAllNode(root);
        split(root);
        int base = ((int) (1e9 + 7));
        return ((int) (ret % base));
    }

}
