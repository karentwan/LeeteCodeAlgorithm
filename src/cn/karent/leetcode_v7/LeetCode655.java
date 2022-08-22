package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.TreeNode;
import java.util.*;

/******************************************
 * 输出二叉树
 * @author wan
 * @date 2022.08.22 07:37
 ******************************************/
public class LeetCode655 {

    class Node {
        int row;
        int col;
        TreeNode root;

        public Node() {
        }

        public Node(int row, int col, TreeNode root) {
            this.row = row;
            this.col = col;
            this.root = root;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        // 求height
        Deque<TreeNode> q1 = new ArrayDeque<>();
        q1.offerLast(root);
        int height = -1;
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q1.pollFirst();
                if (node.left != null) {
                    q1.offerLast(node.left);
                }
                if (node.right != null) {
                    q1.offerLast(node.right);
                }
            }
            height++;
        }
        int n = (1 << (height + 1)) - 1;
        String[][] tmps = new String[height+1][n];
        Deque<Node> que = new ArrayDeque<>();
        que.offerLast(new Node(0, (n-1)/2, root));
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.pollFirst();
                int r = node.row, c = node.col;
                TreeNode treeNode = node.root;
                tmps[r][c] = String.valueOf(treeNode.val);
                if (treeNode.left != null) {
                    que.offerLast(new Node(r+1, c - (1 << (height-r-1)), treeNode.left));
                }
                if (treeNode.right != null) {
                    que.offerLast(new Node(r+1, c+ (1 << (height-r-1)), treeNode.right));
                }
            }
        }
        List<List<String>> rets = new ArrayList<>();
        for (int i = 0; i < tmps.length; i++) {
            List<String> tmp = new ArrayList<>();
            rets.add(tmp);
            for (int j = 0; j < tmps[i].length; j++) {
                tmp.add(tmps[i][j] == null ? "" : tmps[i][j]);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode655 lc = new LeetCode655();
//        Integer[] arr = {1,2};
//        Integer[] arr = {1,2,3,null,4};
        Integer[] arr = {5,3,6,2,4,null,7};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<List<String>> rets = lc.printTree(root);
        for (List<String> ret : rets) {
            for (String s : ret) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

}
