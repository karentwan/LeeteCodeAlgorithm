package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 输出二叉树
 */
public class LeetCode655 {

    private int getHeight(TreeNode root) {
        if( root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private void dfs(String[][] ans, TreeNode root, int idx, int start, int end) {
        int mid = start + (end - start) / 2;
        if( root == null) {
            return;
        }
        ans[idx][mid] = String.valueOf(root.val);
        dfs(ans, root.left, idx+1, start, mid-1);
        dfs(ans, root.right, idx+1, mid+1, end);
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> rets = new ArrayList<>();
        if( root == null) {
            rets.add(new ArrayList<>());
            return rets;
        }
        int height = getHeight(root);
        // 宽度其实就是满二叉树的节点个数
        int width = (1 << height) - 1;
        String[][] ans = new String[height][width];
        for (String[] an : ans) {
            Arrays.fill(an, "");
        }
        dfs(ans, root, 0, 0, width-1);
        for (String[] an : ans) {
            rets.add(Arrays.asList(an));
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode655 lc = new LeetCode655();
        Integer[] arr = {1,2};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<List<String>> rets = lc.printTree(root);
        for (List<String> ret : rets) {
            System.out.println(ret);
        }
    }

}
