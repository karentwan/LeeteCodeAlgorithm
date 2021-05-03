package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * N叉树的后序遍历
 */
public class LeetCode590 {

    private void dfs(Node root, List<Integer> rets) {
        if (root == null) {
            return;
        }
        List<Node> children = root.children;
        for (Node child : children) {
            dfs(child, rets);
        }
        rets.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> rets = new ArrayList<>();
        dfs(root, rets);
        return rets;
    }

    public static void main(String[] args) {

    }

}
