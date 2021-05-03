package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 删点成林
 */
public class LeetCode1110 {

    private void add(TreeNode root, List<TreeNode> rets) {
        if( root != null) {
            rets.add(root);
        }
    }

    private TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> rets) {
        if( root == null) {
            return null;
        }
        root.left = dfs(root.left, set, rets);
        root.right = dfs(root.right, set, rets);
        if( set.contains(root.val)) {
            add(root.left, rets);
            add(root.right, rets);
            root = null;
        }
        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int e : to_delete) {
            set.add(e);
        }
        List<TreeNode> rets = new ArrayList<>();
        if( root == null) {
            return rets;
        }
        if( !set.contains(root.val)) {
            add(root, rets);
        }
        dfs(root, set, rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1110 lc = new LeetCode1110();
        Integer[] arr = {1,2,3,4,5,6,7};
        int[] to_delete = {3,5};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<TreeNode> rets = lc.delNodes(root, to_delete);
        for (TreeNode ret : rets) {
            LeetCodeUtil.levelTraverse(ret);
            System.out.println("=============================");
        }
    }

}
