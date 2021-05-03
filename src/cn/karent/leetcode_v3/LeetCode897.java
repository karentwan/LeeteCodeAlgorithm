package cn.karent.leetcode_v3;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 递增顺序搜索树
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class LeetCode897 {

    private TreeNode root;
    private TreeNode prev;

    private void dfs(TreeNode root) {
        if( root == null) return;
        dfs(root.left);
        if( this.root == null) this.root = root;
        if( prev != null) prev.right = root;
        root.left = null;
        prev = root;
        dfs(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return this.root;
    }

    public static void main(String[] args) {
        LeetCode897 lc = new LeetCode897();
        Integer[] arr = {5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        TreeNode ret = lc.increasingBST(root);
        LeetCodeUtil.levelTraverse(ret);
    }

}
