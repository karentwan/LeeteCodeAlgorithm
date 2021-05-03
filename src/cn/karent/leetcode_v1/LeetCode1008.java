package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 前序遍历构造二叉搜索树
 */
public class LeetCode1008 {


    public TreeNode bstFromPreorder(int[] preorder) {
        if( preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int idx = 0;
        while( idx + 1 < preorder.length && preorder[idx+1] < preorder[0]) {
            idx++;
        }
        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, idx+1));
        root.right = bstFromPreorder(Arrays.copyOfRange(preorder, idx+1, preorder.length));
        return root;
    }

}
