package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

public class FindElements {



//    private TreeNode root = null;
//
//    private void dfs(TreeNode root, int val) {
//        if( root == null) {
//            return;
//        }
//        root.val = val;
//        dfs(root.left, val * 2 + 1);
//        dfs(root.right, val * 2 + 2);
//    }
//
//    public FindElements(TreeNode root) {
//        this.root = root;
//        dfs(root, 0);
//    }
//
//    private boolean find(TreeNode root, int target) {
//        if( root == null) {
//            return false;
//        }
//        if( root.val == target) {
//            return true;
//        }
//        return find(root.left, target) || find(root.right, target);
//    }
//
//    public boolean find(int target) {
//        return find(root, target);
//    }

    private Set<Integer> set = new HashSet<>();
    private TreeNode root = null;

    private void dfs(TreeNode root, int val) {
        if( root == null) {
            return;
        }
        root.val = val;
        set.add(root.val);
        dfs(root.left, val * 2 + 1);
        dfs(root.right, val * 2 + 2);
    }

    public FindElements(TreeNode root) {
        this.root = root;
        dfs(root, 0);
    }

    public boolean find(int target) {
        return set.contains(target);
    }

}
