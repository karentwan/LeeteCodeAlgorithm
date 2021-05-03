package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉树的垂序遍历
 */
public class LeetCode987 {

    class Node implements Comparable<Node>{

        private int row;

        private int col;

        private int val;

        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            if( col != o.col) {
                return col - o.col;
            } else if( row != o.col ) {
                return row - o.row;
            }
            return val - o.val;
        }
    }


    private void dfs(TreeNode root, int row, int col, PriorityQueue<Node> que) {
        if( root == null) {
            return;
        }
        que.offer(new Node(row, col, root.val));
        dfs(root.left, row+1, col-1, que);
        dfs(root.right, row+1, col+1, que);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        dfs(root, 0, 0, que);
        List<List<Integer>> rets = new ArrayList<>();
        int col = Integer.MIN_VALUE;
        while( !que.isEmpty() ) {
            List<Integer> ret = new ArrayList<>();
            Node node = que.poll();
            col = node.col;
            ret.add(node.val);
            while( !que.isEmpty() && que.peek().col == col) {
                node = que.poll();
                ret.add(node.val);
            }
            rets.add(ret);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode987 lc = new LeetCode987();
//        Integer[] arr = {3,9,20,null,null,15,7};
        Integer[] arr = {1,2,3,4,5,6,7};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<List<Integer>> rets = lc.verticalTraversal(root);
//        System.out.println(rets);
        System.out.println(rets);
    }
}
