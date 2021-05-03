package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉搜索树与双向链表
 * @author wan
 * @date 2021.04.07
 */
public class Offer36 {

    private TreeNode head = null;
    private TreeNode prev = null;

    private void dfs(TreeNode root) {
        if( root == null) {
            prev.right = root;
            return ;
        }
        dfs(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        dfs(root.right);
    }

    public TreeNode treeToDoublyList(TreeNode root) {
        if( root == null) {
            return null;
        }
        head = prev = new TreeNode();
        dfs(root);
        prev.right = head.right;
        head.right.left = prev;
        return head.right;
    }

    public static void main(String[] args) {
        Integer[] arr = {4,2,5,1,3};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        Offer36 lc = new Offer36();
        TreeNode ret = lc.treeToDoublyList(root);
        TreeNode p = ret;
        do{
            System.out.print(p.val + " ");
            p = p.right;
        } while (p != ret);
    }

}
