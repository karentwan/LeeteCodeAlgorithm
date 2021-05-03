package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 求和路径
 */
public class Offer0412 {

    private int ret = 0;

    private void count(TreeNode root, int sum) {
        if( root == null) {
            return;
        }
        sum -= root.val;
        if( sum == 0) {
            ret++;
        }
        count(root.left, sum);
        count(root.right, sum);
    }

    private void dfs(TreeNode root, int sum) {
        if( root == null) {
            return;
        }
        count(root, sum);
        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

}
