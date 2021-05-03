package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 翻转二叉树以匹配先序遍历
 */
public class LeetCode971 {

    private int idx = 0;

    private TreeNode dfs(TreeNode root, int[] voyage, List<Integer> rets) {
        if( root == null ) {
            return root;
        }
        if( root.val != voyage[idx]) {
            return null;
        }
        idx++;
        TreeNode tmp = null;
        if( root.left != null) {
            tmp = dfs(root.left, voyage, rets);
            if( tmp == null) {
                rets.add(root.val);
                TreeNode left = root.left;
                tmp = dfs(root.right, voyage, rets);
                root.right = left;
            }
            if( tmp == null) {
                return null;
            }
            root.left = tmp;
        }
        if( root.right != null ) {
            tmp = dfs(root.right, voyage, rets);
            if( tmp == null) {
                return null;
            }
        }
        return root;
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> rets = new ArrayList<>();
        TreeNode tmp = dfs(root, voyage, rets);
        if( tmp == null) {
            rets.clear();
            rets.add(-1);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode971 lc = new LeetCode971();
//        Integer[] arr = {1,2,3};
//        int[] voyage = {1,3,2};
//        Integer[] arr = {1,2};
//        int[] voyage = {2,1};
        Integer[] arr = {1,2,3};
        int[] voyage = {1,2,3};
//        Integer[] arr = {1,null,2,null,3};
//        int[] voyage = {1,3,2};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<Integer> rets = lc.flipMatchVoyage(root, voyage);
        for (Integer ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
