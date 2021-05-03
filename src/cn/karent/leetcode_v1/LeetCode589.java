package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * N叉树的前序遍历
 */
public class LeetCode589 {

    private void dfs(Node root, List<Integer> rets) {
        if (root == null) {
            return;
        }
        rets.add(root.val);
        List<Node> children = root.children;
        for (Node child : children) {
            dfs(child, rets);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> rets = new ArrayList<>();
        dfs(root, rets);
        return rets;
    }

}
