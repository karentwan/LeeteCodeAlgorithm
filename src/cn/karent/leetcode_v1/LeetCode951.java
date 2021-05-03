package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 翻卷等价二叉树
 */
public class LeetCode951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if( root1 == null ) {
            return root2 == null;
        }
        if( root2 == null) {
            return root1 == null;
        }
        if( root1.val == root2.val) {
            if( flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) {
                return true;
            }
            if( flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode951 lc = new LeetCode951();
        Integer[] arr1 = {1,2,3,4,5,6,null,null,null,7,8};
        Integer[] arr2 = {1,3,2,null,6,4,5,null,null,null,null,8,7};
        TreeNode root1 = LeetCodeUtil.arr2tree(arr1);
        TreeNode root2 = LeetCodeUtil.arr2tree(arr2);
        System.out.println(lc.flipEquiv(root1, root2));
    }

}
