package cn.karent.leetcode_v1;

import java.util.*;
import cn.karent.util.*;

/**
 * 最大层内元素和
 */
public class LeetCode1161 {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int ret = 0;
        int max = Integer.MIN_VALUE;
        int level = 1;
        while ( !que.isEmpty() ) {
            int size = que.size();
            int val = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                val += node.val;
                if( node.left != null ) {
                    que.offer(node.left);
                }
                if( node.right != null ) {
                    que.offer(node.right);
                }
            }
            if( max < val) {
                max = val;
                ret = level;
            }
            level++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1161 lc = new LeetCode1161();
        Integer[] arr = {1,7,0,7,-8,null,null};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.maxLevelSum(root);
        System.out.println(ret);
    }

}
