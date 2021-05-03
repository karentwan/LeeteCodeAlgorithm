package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;

/**
 * 奇偶树
 */
public class LeetCode1609 {

    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 0;
        while ( !que.isEmpty() ) {
            int size = que.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if( (level % 2 == 0 && (node.val % 2 == 0 || node.val <= prev))
                        || (level % 2 != 0 && (node.val % 2 != 0 || node.val >= prev))) {
                    return false;
                }
                prev = node.val;
                if( node.left != null) {
                    que.offer(node.left);
                }
                if( node.right != null) {
                    que.offer(node.right);
                }
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1609 lc = new LeetCode1609();
        Integer[] arr = {1,10,4,3,null,7,9,12,8,6,null,null,2};
//        Integer[] arr = {5,9,1,3,5,7};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        boolean ret = lc.isEvenOddTree(root);
        System.out.println(ret);
    }

}
