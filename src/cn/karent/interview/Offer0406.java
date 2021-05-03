package cn.karent.interview;

import cn.karent.util.*;

/**
 * 后继者
 */
public class Offer0406 {

    private TreeNode prev = null;

    private TreeNode node = null;

    private void dfs(TreeNode root, TreeNode p) {
        if( root == null) {
           return;
        }
        dfs(root.left, p);
        if(  p == prev) {
            node = root;
        }
        prev = root;
        dfs(root.right, p);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return node;
    }

    public static void main(String[] args) {
        Offer0406 offer = new Offer0406();
        Integer[] arr = {5,3,6,2,4,null,null,1};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = offer.inorderSuccessor(root, new TreeNode(1));
        System.out.println(ret.val);
    }

}
