package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.TreeNode;
import java.util.*;

/******************************************
 * 二叉树最大宽度
 * @author wan
 * @date 2022.08.27 08:40
 ******************************************/
public class LeetCode662 {

    class Node {
        int number;
        TreeNode node;

        public Node() {
        }

        public Node(int number, TreeNode node) {
            this.number = number;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<Node> que = new ArrayDeque<>();
        int maxDepth = 1;
        que.offerLast(new Node(1, root));
        while (!que.isEmpty()) {
            int size = que.size();
            int start = 0;
            for (int i = 0; i < size; i++) {
                Node node = que.pollFirst();
                TreeNode treeNode = node.node;
                int number = node.number;
                if (treeNode.left != null) {
                    int leftNumber = number * 2;
                    que.offerLast(new Node(leftNumber, treeNode.left));
                    if (start == 0) {
                        start = leftNumber;
                    } else {
                        maxDepth = Math.max(maxDepth, leftNumber - start + 1);
                    }
                }
                if (treeNode.right != null) {
                    int rightNumber = number * 2 + 1;
                    que.offerLast(new Node(rightNumber, treeNode.right));
                    if (start == 0) {
                        start = rightNumber;
                    } else {
                        maxDepth = Math.max(maxDepth, rightNumber - start + 1);
                    }
                }
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        LeetCode662 lc = new LeetCode662();
        Integer[] arr = {1, 3, 2, 5, 3, null, 9};
//        Integer[] arr = {1,3,2,5,null,null,9,6,null,7};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        System.out.println(lc.widthOfBinaryTree(root));
    }

}
