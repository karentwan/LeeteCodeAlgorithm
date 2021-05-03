package cn.karent.leetcode_v3;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉搜索树节点最小距离
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode783 {

    private int prev = Integer.MIN_VALUE / 2;

    private int ret = Integer.MAX_VALUE;

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        ret = Math.min(ret, root.val - prev);
        prev = root.val;
        dfs(root.right);
    }

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }

    public static void main(String[] args) {

    }

}
