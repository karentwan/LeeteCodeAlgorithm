package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 层数最深叶子节点的和
 */
public class LeetCode1302 {

    class Node {

        private int path;

        private int val;

        public Node(int path, int val) {
            this.path = path;
            this.val = val;
        }
    }

    private Stack<Node> st = new Stack<>();

    private void dfs(TreeNode root, int path) {
        if( root == null) {
            return;
        }
        if( root.left == null && root.right == null) {
            while ( !st.isEmpty() && path > st.peek().path) {
                st.pop();
            }
            Node node = new Node(path, root.val);
            if( st.isEmpty() || path == st.peek().path ) {
                st.push(node);
            }
            return;
        }
        dfs(root.left, path+1);
        dfs(root.right, path+1);
    }

    public int deepestLeavesSum(TreeNode root) {
        int ret = 0;
        dfs(root, 0);
        while( !st.isEmpty()) {
            Node node = st.pop();
            ret += node.val;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1302 lc = new LeetCode1302();
        Integer[] arr = {1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.deepestLeavesSum(root);
        System.out.println(ret);
    }

}
