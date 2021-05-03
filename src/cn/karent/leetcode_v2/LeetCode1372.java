package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 二叉树中的最长交错路径
 */
public class LeetCode1372 {

    private int ret = 0;

    private void dfs(TreeNode root, boolean left, int path) {
        ret = Math.max(ret, path);
        if( left ) {  // 如果当前节点是父节点的左节点, 则当前只能去右节点
            if( root.right != null) {
                dfs(root.right, false, path+1);
            }
            if( root.left != null) {
                dfs(root.left, true, 1);
            }
        } else {
            if( root.left != null) {
                dfs(root.left, true, path+1);
            }
            if( root.right != null) {
                dfs(root.right, false, 1);
            }
        }
    }

    public int longestZigZag(TreeNode root) {
        if( root == null) {
            return 0;
        }
        dfs(root, true, 0);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1372 lc = new LeetCode1372();
        Integer[] arr = {1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.longestZigZag(root);
        System.out.println(ret);
    }

}
