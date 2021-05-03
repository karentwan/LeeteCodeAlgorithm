package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 二叉树的完全性检验
 */
public class LeetCode958 {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int n = 1;
        while ( !que.isEmpty() ) {
            int size = que.size();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode p = que.poll();
                if( p.left != null) {
                    if( n != size || flag) {
                        return false;
                    }
                    que.offer(p.left);
                } else {
                    flag = true;
                }
                if( p.right != null) {
                    if( n != size || flag) {
                        return false;
                    }
                    que.offer(p.right);
                } else {
                    flag = true;
                }
            }
            n *= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode958 lc = new LeetCode958();
//        Integer[] arr = {1,2,3,4,5,6};
//        Integer[] arr = {1,2,3,4,5,null,6};
        Integer[] arr = {1,2,3,5,null,7,8};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        System.out.println(lc.isCompleteTree(root));
    }

}
