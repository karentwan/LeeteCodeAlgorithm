package cn.karent.leetcode_v6;

import java.util.*;
import cn.karent.util.*;

/***********************************************
 * description: 二叉搜索树中第k小的元素
 * @author wan
 * @date 2021.10.17
 ***********************************************/
public class LeetCode230 {

    private int idx = 0;

    private int ret = 0;

    private int k = 0;

    private void dfs(TreeNode root) {
        if( root == null) return;
        dfs(root.left);
        idx++;
        if( idx == k) {
            ret = root.val;
        }
        dfs(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return ret;
    }

    public static void main(String[] args) {

    }

}
