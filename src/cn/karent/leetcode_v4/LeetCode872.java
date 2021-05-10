package cn.karent.leetcode_v4;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 叶子相似的树
 * @author wan
 * @date 2021.05.10
 ********************************************/
public class LeetCode872 {

    private void dfs(TreeNode root, List<Integer> list) {
        if( root == null) return;
        if( root.left == null && root.right == null) list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> left = new ArrayList<>();
        dfs(root1, left);
        List<Integer> right = new ArrayList<>();
        dfs(root2, right);
        int i = 0;
        for (; i < left.size() && i < right.size(); i++) {
            if( left.get(i) != right.get(i)) return false;
        }
        return i == left.size() && i == right.size();
    }

    public static void main(String[] args) {

    }

}
