package cn.karent.leetcode_v7;

import cn.karent.util.TreeNode;
import java.util.*;

/******************************************
 * 修剪二叉搜索树
 * @author wan
 * @date 2022.09.10 10:10
 ******************************************/
public class LeetCode669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        TreeNode left = trimBST(root.left, low, high);
        TreeNode right = trimBST(root.right, low, high);
        if (root.val < low || root.val > high) {
            return left == null ? right : left;
        }
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        LeetCode669 lc = new LeetCode669();
    }

}
