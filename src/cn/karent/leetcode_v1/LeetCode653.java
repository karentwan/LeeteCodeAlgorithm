package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;


/**
 * 两数之和 四- 输入 BST
 */
public class LeetCode653 {

/*
    private List<Integer> list = new ArrayList<>();

    private void dfs(TreeNode root) {
        if( root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        int i = 0, j = list.size()-1;
        while( i < j) {
            int tmp = list.get(i) + list.get(j);
            if (tmp == k) {
                return true;
            } else if( tmp > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    */


    private Map<Integer, Boolean> map = new HashMap<>();

    public boolean findTarget(TreeNode root, int k) {
        if( root == null) {
            return false;
        }
        if( map.getOrDefault(k - root.val, false)) {
            return true;
        }
        map.put(root.val, true);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}
