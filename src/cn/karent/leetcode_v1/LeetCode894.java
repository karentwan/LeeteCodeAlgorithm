package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 所有可能的满二叉树
 */
public class LeetCode894 {


    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if( n == 0) {
            return ret;
        }
        if( n == 1) {
            TreeNode root = new TreeNode();
            ret.add(root);
            return ret;
        }
        for (int i = 1; i < n; i+=2) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(n - i - 1);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode();
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }

}
