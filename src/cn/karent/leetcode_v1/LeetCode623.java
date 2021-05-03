package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 在二叉树中增加一行
 */
public class LeetCode623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> que = new LinkedList<>();
        if( depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        que.offer(root);
        while( !que.isEmpty() && depth > 2) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if( node.left != null) {
                    que.offer(node.left);
                }
                if( node.right != null) {
                    que.offer(node.right);
                }
            }
            depth--;
        }
        while( !que.isEmpty() ) {
            TreeNode node = que.poll();
            TreeNode left = new TreeNode(val);
            TreeNode right = new TreeNode(val);
            left.left = node.left;
            right.right = node.right;
            node.left = left;
            node.right = right;
        }
        return root;
    }

    public static void main(String[] args) {
        LeetCode623 lc = new LeetCode623();
        Integer[] arr = {4,2,6,3,1,5,null};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int val = 1;
        int depth = 2;
        TreeNode newRoot = lc.addOneRow(root, val, depth);
        LeetCodeUtil.levelTraverse(newRoot);
    }

}
