package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 寻找重复的子树
 */
public class LeetCode652 {

    private String dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> rets) {
        if (root == null) {
            return "#";
        }
        String serial = root.val + "," + dfs(root.left, map, rets) + "," + dfs(root.right, map, rets);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if( map.get(serial) == 2) {
            rets.add(root);
        }
        return serial;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> rets = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        dfs(root, map, rets);
        return rets;
    }

}
