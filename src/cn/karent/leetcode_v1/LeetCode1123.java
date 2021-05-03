package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 最深叶节点的最近公共祖先
 */
public class LeetCode1123 {

    class Node {

        private int path;

        private TreeNode node;

        public Node(int path, TreeNode node) {
            this.path = path;
            this.node = node;
        }
    }

    private Node dfs(TreeNode root) {
        if( root == null) {
            return new Node(0, null);
        }
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        if( left.path < right.path) {
            right.path++;
            return right;
        } else if( left.path > right.path) {
            left.path++;
            return left;
        }
        Node node = new Node(left.path + 1, root);
        return node;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Node ret = dfs(root);
        return ret.node;
    }

    public static void main(String[] args) {
        LeetCode1123 lc = new LeetCode1123();
//        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        Integer[] arr = {1};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = lc.lcaDeepestLeaves(root);
        LeetCodeUtil.levelTraverse(ret);
    }

}
