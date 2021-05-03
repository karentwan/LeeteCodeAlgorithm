package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉搜索树
 */
public class LeetCode501 {

    private List<Integer> ans = new ArrayList<>();

    private int cnt = 0;
    private int maxCnt = 0;
    private int base = Integer.MAX_VALUE;

    private void dfs(TreeNode root) {
        if( root == null) {
            return;
        }
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private void update(int val) {
        if( base == val) {
            cnt++;
        } else {
            base = val;
            cnt = 1;
        }
        if( cnt == maxCnt) {
            ans.add(val);
        } else if( cnt > maxCnt) {
            maxCnt = cnt;
            ans.clear();
            ans.add(val);
        }
    }

    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ret = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ret[i] = ans.get(i);
        }
        return ret;
    }

}
