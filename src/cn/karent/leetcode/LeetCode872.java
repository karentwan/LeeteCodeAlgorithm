package cn.karent.leetcode;

import cn.karent.util.*;
import java.util.*;

/**
 * 叶子相似的树
 */
public class LeetCode872 {

    public void dfs(TreeNode root, List<Integer> leaves) {
        if( root == null) {
            return;
        }
        if( root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        dfs(root.left, leaves);
        dfs(root.right, leaves);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leftLeaves = new ArrayList<>();
        dfs(root1, leftLeaves);
        List<Integer> rightLeaves = new ArrayList<>();
        dfs(root2, rightLeaves);
        int i = 0;
        boolean ret = true;
        while( i < leftLeaves.size() && i < rightLeaves.size()) {
            if( leftLeaves.get(i) != rightLeaves.get(i)) {
                ret = false;
                break;
            }
            i++;
        }
        return ret && leftLeaves.size() == rightLeaves.size();
    }
}
