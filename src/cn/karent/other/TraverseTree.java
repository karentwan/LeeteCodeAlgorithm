package cn.karent.other;

import cn.karent.util.*;
import java.util.*;

/**
 * 非递归方式遍历树
 */
public class TraverseTree {

    private static void preOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while( !st.isEmpty()) {
            TreeNode node = st.pop();
            System.out.print(node.val + " ");
            if( node.right != null) {
                st.push(node.right);
            }
            if( node.left != null) {
                st.push(node.left);
            }
        }
        System.out.println();
    }

    private static void inOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while( p != null || !st.isEmpty()) {
            while( p != null) {
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            System.out.print(p.val + " ");
            p = p.right;
        }
        System.out.println();
    }

    private static void postOrder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while( p != null || !st.isEmpty()) {
            while( p != null) {
                st.push(p);
                p = p.left;
            }
            p = st.peek();
            if( p.right == null || p.right == pre) {
                System.out.print(p.val + " ");
                pre = p;
                st.pop();
                p = null;
            } else {
                p = p.right;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {9,3,2,4,1,null,6};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        preOrder(root);
        inOrder(root);
        postOrder(root);
    }

}
