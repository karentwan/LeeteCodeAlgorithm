package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 最大二叉树
 */
public class LeetCode654 {

    private TreeNode dfs(int[] nums, int start, int end) {
        if( start > end) {
            return null;
        }
        int idx = start;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if( nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = dfs(nums, start, idx-1);
        node.right = dfs(nums, idx+1, end);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = dfs(nums, 0, nums.length-1);
        return root;
    }

    public static void main(String[] args) {
        LeetCode654 lc = new LeetCode654();
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = lc.constructMaximumBinaryTree(nums);
        LeetCodeUtil.levelTraverse(root);
    }

}
