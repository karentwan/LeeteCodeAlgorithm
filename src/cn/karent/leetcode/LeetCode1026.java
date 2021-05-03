package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 节点与其祖先之间的最大差值
 */
public class LeetCode1026 {

    final int INFINITY = Integer.MIN_VALUE / 2;

    private int ret = INFINITY;

    private int dfsMin(TreeNode root) {
        if( root == null) {
            return INFINITY;
        }
        int left = dfsMin(root.left);
        int right = dfsMin(root.right);
        if( left == INFINITY && right == INFINITY) {
            return root.val;
        }
        int min = root.val;
        if( left == INFINITY) {
            ret = Math.max(ret, Math.abs(root.val - right));
            min = Math.min(min, right);
        } else if( right == INFINITY) {
            ret = Math.max(ret, Math.abs(root.val - left));
            min = Math.min(min, left);
        } else {
            int val = Math.min(left, right);
            ret = Math.max(ret, Math.abs(root.val - val));
            min = Math.min(min, val);
        }
        return min;
    }

    private int dfsMax(TreeNode root) {
        if( root == null) {
            return INFINITY;
        }
        int left = dfsMax(root.left);
        int right = dfsMax(root.right);
        if( left == INFINITY && right == INFINITY) {
            return root.val;
        }
        int max = root.val;
        if( left == INFINITY) {
            ret = Math.max(ret, Math.abs(root.val - right));
            max = Math.max(max, right);
        } else if( right == INFINITY) {
            ret = Math.max(ret, Math.abs(root.val - left));
            max = Math.max(max, left);
        } else {
            int val = Math.max(left, right);
            ret = Math.max(ret, Math.abs(root.val - val));
            max = Math.max(max, val);
        }
        return max;
    }

    public int maxAncestorDiff1(TreeNode root) {
        dfsMin(root);
        dfsMax(root);
        return ret;
    }

    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;
    private int rets = Integer.MIN_VALUE;

    private void dfs(TreeNode root) {
        if( root == null ) {
            return;
        }
        if( max != Integer.MIN_VALUE) {
            rets = Math.max(rets, Math.abs(root.val - max));
        }
        if( min != Integer.MAX_VALUE){
            rets = Math.max(rets, Math.abs(root.val - min));
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        int tmpMax = max;
        int tmpMin = min;
        dfs(root.left);
        max = tmpMax;
        min = tmpMin;
        dfs(root.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1026 lc = new LeetCode1026();
        Integer[] nums = {8,3,10,1,6,null,14,null,null,4,7,13};
//        Integer[] nums = {2,null,0,null,4,null,3,null,1};
//        Integer[] nums = {2,0,8,3,10,7,1,4,null,null,null,null,null,null,6,5,null,9};
        TreeNode root = LeetCodeUtil.arr2tree(nums);
        int ret = lc.maxAncestorDiff(root);
        System.out.println(ret);
    }
}
