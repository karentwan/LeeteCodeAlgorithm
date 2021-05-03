package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 祖父节点值为偶数的节点和
 */
public class LeetCode1315 {

    private int ret = 0;

    private void dfs(TreeNode root, TreeNode gf, TreeNode f) {
        if(root == null) {
            return;
        }
        if( gf != null && gf.val % 2 == 0) {
            ret += root.val;
        }
        dfs(root.left, f, root);
        dfs(root.right, f, root);
    }

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1315 lc = new LeetCode1315();
        Integer[] arr = {6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.sumEvenGrandparent(root);
        System.out.println(ret);
    }

}
