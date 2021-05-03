package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 另一个树的子树
 */
public class LeetCode572 {

/*    private boolean dfs(TreeNode s, TreeNode t, TreeNode original) {
        if( t == null) {
            return s == null;
        }
        if( s == null) {
            return t == null;
        }
        if( s.val == t.val && dfs(s.left, t.left, original) && dfs(s.right, t.right, original)) {
            return true;
        }
        return dfs(s.left, original, original) || dfs(s.right, original, original);
    }
    // 超时
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t, t);
    }*/

    private boolean dfs(TreeNode s, TreeNode t) {
        if( s == null ) {
            return t == null;
        }
        if( t == null) {
            return s == null;
        }
        return s.val == t.val && dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if( s == null) {
            return t == null;
        }
        return dfs(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args) {
        LeetCode572 lc = new LeetCode572();
//        Integer[] arr1 = {3,4,5,1,2};
//        Integer[] arr2 = {4,1,2};
//        Integer[] arr1 = {3,4,5,1,2,null,null, null,0};
//        Integer[] arr2 = {4,1,2};
        Integer[] arr1 = {3,4,5,1,null,2};
        Integer[] arr2 = {3,1,2};
        TreeNode s = LeetCodeUtil.arr2tree(arr1);
        TreeNode t = LeetCodeUtil.arr2tree(arr2);
        boolean ret = lc.isSubtree(s, t);
        System.out.println(ret);
    }

}
