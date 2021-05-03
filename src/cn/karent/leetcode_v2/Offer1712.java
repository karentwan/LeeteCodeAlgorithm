package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 面试题 17.12 BiNode
 */
public class Offer1712 {

    private TreeNode root = null;

    private TreeNode prev = null;

    private void dfs(TreeNode root) {
        if( root == null) {
            return;
        }
        dfs(root.left);
        if( this.root == null) {
            this.root = root;
        }
        root.left = null;
        if( prev != null) {
            prev.right = root;
        }
        prev = root;
        dfs(root.right);
    }

    public TreeNode convertBiNode(TreeNode root) {
       dfs(root);
       return this.root;
    }

    public static void main(String[] args) {
        Offer1712 offer = new Offer1712();
        Integer[] arr = {4,2,5,1,3,null,6,0};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = offer.convertBiNode(root);
        LeetCodeUtil.levelTraverse(ret);
    }

}
