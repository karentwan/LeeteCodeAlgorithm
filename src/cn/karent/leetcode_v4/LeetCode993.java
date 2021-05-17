package cn.karent.leetcode_v4;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 二叉树的堂兄节点
 * @author wan
 * @date 2021.05.17
 ********************************************/
public class LeetCode993 {

    class Node {
        TreeNode parent;
        int depth;
        public Node(TreeNode parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }
    }

    private Node dfs(TreeNode root, TreeNode parent, int x, int depth) {
        if( root == null) return null;
        if( root.val == x) {
            return new Node(parent, depth);
        }
        Node left = dfs(root.left, root, x, depth + 1);
        if( left == null) return dfs(root.right, root, x, depth+1);
        return left;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Node left = dfs(root, null,  x,1);
        Node right = dfs(root, null, y, 1);
        if( left == null || right == null) return false;
        return left.parent != right.parent && left.depth == right.depth;
    }

    public static void main(String[] args) {
        LeetCode993 lc = new LeetCode993();
//        Integer[] arr = {1, 2, 3, 4};
//        int x = 4;
//        int y = 3;
//        Integer[] arr = {1,2,3,null,4,null,5};
//        int x = 5;
//        int y = 4;
        Integer[] arr = {1,2,3,null,4};
        int x = 2;
        int y = 3;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        boolean ret = lc.isCousins(root, x, y);
        System.out.println(ret);
    }

}
