package cn.karent.leetcode_v2;

import cn.karent.util.*;
import java.util.*;

/**
 * 二叉树中的伪回文路径
 */
public class LeetCode1457 {

    private int ret = 0;

    private boolean isPalindrome(Map<Integer, Integer> map) {
        int odd = 0;
        for (int key : map.keySet()) {
            if( map.get(key) % 2 != 0) {
                odd++;
            }
        }
        return odd <= 1;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if( root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        if( root.left == null && root.right == null) {
            if( isPalindrome(map) ) {
                ret++;
            }
            map.put(root.val, map.get(root.val)-1);
            return;
        }
        dfs(root.left, map);
        dfs(root.right, map);
        map.put(root.val, map.get(root.val)-1);
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1457 lc = new LeetCode1457();
        Integer[] arr = {2,3,1,3,1,null,1};
//        Integer[] arr = {2,1,1,1,3,null,null,null,null,null,1};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.pseudoPalindromicPaths(root);
        System.out.println(ret);
    }

}
