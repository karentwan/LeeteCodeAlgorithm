package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 根到叶路径上的不足节点
 */
public class LeetCode1080 {

    class Node {
        private int path;
        private TreeNode node;

        public Node(int path, TreeNode node) {
            this.path = path;
            this.node = node;
        }
    }

    private Node dfs(TreeNode root, int val, int limit) {
        if( root == null) {
            return new Node(0, null);
        }
        Node left = dfs(root.left, val + root.val, limit);
        Node right = dfs(root.right, val + root.val, limit);
        int max = root.val;
        if( root.left == null) {
            max += right.path;
        } else if( root.right == null) {
            max += left.path;
        } else if( root.left != null && root.right != null){
            max += Math.max(left.path, right.path);
        }
        root.left = left.node;
        root.right = right.node;
        Node ret = new Node(max, root);
        if( max + val < limit) {
            ret.node = null;
        }
        return ret;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        Node ret = dfs(root, 0, limit);
        return ret.node;
    }

    public static void main(String[] args) {
        LeetCode1080 lc = new LeetCode1080();
//        Integer[] arr = {1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14};
//        int limit = 1;
//        Integer[] arr = {5,4,8,11,null,17,4,7,1,null,null,5,3};
//        int limit = 22;
        Integer[] arr = {5,-6,-6};
        int limit = 0;
//        Integer[] arr = {1,2,-3,-5,null,4,null};
//        int limit = -1;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = lc.sufficientSubset(root, limit);
        LeetCodeUtil.levelTraverse(ret);
    }

}
