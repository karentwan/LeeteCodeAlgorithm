package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉树最大宽度
 */
public class LeetCode662 {

    class Node {

        private TreeNode node;

        private int pos;

        public Node(TreeNode node, int pos) {
            this.node = node;
            this.pos = pos;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> que = new LinkedList<>();
        int ret = 0;
        que.offer(new Node(root, 0));
        while ( !que.isEmpty() ) {
            int size = que.size();
            int prev = que.peek().pos;
            int cur = 0;
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                TreeNode tn = node.node;
                if( tn.left != null) {
                    que.offer(new Node(tn.left, node.pos * 2 + 1));
                }
                if( tn.right != null) {
                    que.offer(new Node(tn.right, node.pos * 2 + 2));
                }
                cur = Math.max(cur, node.pos - prev + 1);
            }
            ret = Math.max(ret, cur);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode662 lc = new LeetCode662();
        Integer[] arr = {1,3,2,5,3,null,9};
//        Integer[] arr = {1,3,null,5,2};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.widthOfBinaryTree(root);
        System.out.println(ret);
    }

}
