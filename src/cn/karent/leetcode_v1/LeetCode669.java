package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 修剪二叉搜索树
 */
public class LeetCode669 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if( root.val < low) {  // 左子树不要
            return trimBST(root.right, low, high);
        } else if( root.val > high) {  // 右子树不要
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {
        LeetCode669 lc = new LeetCode669();
//        Integer[] arr = {1,0,2};
//        int low = 1;
//        int high = 2;
//        Integer[] arr = {3,0,4,null,2,null,null,1};
//        int low = 1;
//        int high = 3;
//        Integer[] arr = {1};
//        int low = 1;
//        int high = 2;
        Integer[] arr = {3,1,4,null,2};
        int low = 3;
        int high = 4;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = lc.trimBST(root, low, high);
        LeetCodeUtil.levelTraverse(ret);
    }

}
