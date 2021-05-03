package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 两颗二叉搜索树中的所有元素
 */
public class LeetCode1305 {


    private void dfs(TreeNode root, List<Integer> list) {
        if( root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> rets = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if( list1.get(i) <= list2.get(j)) {
                rets.add(list1.get(i++));
            } else {
                rets.add(list2.get(j++));
            }
        }
        while( i < list1.size()) {
            rets.add(list1.get(i++));
        }
        while (j < list2.size()) {
            rets.add(list2.get(j++));
        }
        return rets;
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return merge(list1, list2);
    }

}
