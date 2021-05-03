package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 根据前序和后序遍历构造二叉树
 */
public class LeetCode889 {

    private TreeNode dfs(int[] pre, int[] post) {
        if( pre.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if( pre.length == 1) {
            return root;
        }
        int idx = 0;
        for (int i = 0; i < post.length; i++) {
            if( post[i] == pre[1]) {
                idx = i+1;
            }
        }
        root.left = dfs(Arrays.copyOfRange(pre, 1, idx+1),
                Arrays.copyOfRange(post, 0, idx));
        root.right = dfs(Arrays.copyOfRange(pre, idx+1, pre.length),
                Arrays.copyOfRange(post, idx, post.length));
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, post);
    }

    public static void main(String[] args) {
        LeetCode889 lc = new LeetCode889();
        int[] pre = {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        TreeNode root = lc.constructFromPrePost(pre, post);
        LeetCodeUtil.levelTraverse(root);
    }

}
