package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 具有所有最深节点的最小子树
 */
public class LeetCode865 {

    private TreeNode node = null;

    private int depth = 0;

    private int dfs(TreeNode root, int depth) {
        if( root == null) {
            return 0;
        }
        int left = dfs(root.left, depth+1);
        int right = dfs(root.right, depth+1);
        if( left + depth == right + depth) {
            if( left + depth >= this.depth) {
                node = root;
                this.depth = left + depth;
            }
        }
        return Math.max(left, right)+1;
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return node;
    }


    public static void main(String[] args) {
        LeetCode865 lc = new LeetCode865();
//        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
//        Integer[] arr = {3};
        Integer[] arr = {0,1,3,null,2};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = lc.subtreeWithAllDeepest(root);
        LeetCodeUtil.levelTraverse(ret);
    }
}
