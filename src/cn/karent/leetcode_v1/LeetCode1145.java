package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 二叉树着色游戏
 * 封锁 红色节点的路径, 因此要找到最大的联通路径
 */
public class LeetCode1145 {

    private int left = 0;
    private int right = 0;

    private int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, val);
        int right = dfs(root.right, val);
        if( root.val == val) {
            this.left = left;
            this.right = right;
        }
        return left + right + 1;
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int half = n / 2;
        dfs(root, x);
        return left > half || right > half || left + right < half;
    }

}
