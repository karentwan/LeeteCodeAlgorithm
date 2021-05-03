package cn.karent.leetcode_v2;

import cn.karent.util.*;
import java.util.*;

/**
 * 二叉树中和为某一值的路径
 */
public class Offer34 {

    private List<List<Integer>> rets = new ArrayList<>();

    private void dfs(TreeNode root, int target, List<Integer> ret) {
        if( root == null) {
            return;
        }
        target -= root.val;
        ret.add(root.val);
        if( root.left == null && root.right == null && target == 0) {
            rets.add(new ArrayList<>(ret));
        }
        dfs(root.left, target, ret);
        dfs(root.right, target, ret);
        ret.remove(ret.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, target, ret);
        return rets;
    }

}
