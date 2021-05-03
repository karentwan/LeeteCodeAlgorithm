package cn.karent.leetcode_v2;

import cn.karent.util.*;
import java.util.*;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator {

    private List<Integer> data = new ArrayList<>();

    private int idx = 0;

    private void dfs(TreeNode root) {
        if( root == null) {
            return;
        }
        dfs(root.left);
        data.add(root.val);
        dfs(root.right);
    }

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    public int next() {
        return data.get(idx++);
    }

    public boolean hasNext() {
        return idx < data.size();
    }

}
