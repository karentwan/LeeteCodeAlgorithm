package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.TreeNode;

import java.util.*;

/******************************************
 * 另一棵树的子树
 * @author wan
 * @date 2022.09.10 12:10
 ******************************************/
public class LeetCode572 {

    private boolean same(TreeNode root, TreeNode root2) {
        if (root == null ^ root2 == null) return false;
        if (root == null && root2 == null) return true;
        return root.val == root2.val && same(root.left, root2.left) && same(root.right, root2.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        return same(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        LeetCode572 lc = new LeetCode572();
        Integer[] arr = {3,4,5,1,2};
        Integer[] subRoot = {4,1,2};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode root2 = LeetCodeUtil.arr2tree(subRoot);
        System.out.println(lc.isSubtree(root, root2));
    }

}
