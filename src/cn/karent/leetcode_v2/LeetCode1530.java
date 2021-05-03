package cn.karent.leetcode_v2;

import cn.karent.util.*;
import java.util.*;

/**
 * 好叶子节点对的数量
 */
public class LeetCode1530 {

    private int ret = 0;

    private int[] dfs(TreeNode root, int distance) {
        // depths[i] 表示有depths[i]个叶子节点到当前节点的距离为i
        int[] depths = new int[distance+1];
        if( root == null) {
            return depths;
        }
        if( root.left == null && root.right == null) { // 叶子节点
            // 与叶子节点距离为0的节点有一个（即叶子节点本身）
            depths[0] = 1;
            return depths;
        }
        int[] leftDepths = dfs(root.left, distance);
        int[] rightDepths = dfs(root.right, distance);
        for (int i = 0; i < distance; i++) {
            depths[i+1] = leftDepths[i] + rightDepths[i];
        }
        for (int i = 0; i < distance; i++) {
            for (int j = 0; j + i + 2 <= distance; j++) {
                ret += leftDepths[i] * rightDepths[j];
            }
        }
        return depths;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1530 lc = new LeetCode1530();
//        Integer[] arr = {1,2,3,null,4};
//        int distance = 3;
//        Integer[] arr = {1,2,3,4,5,6,7};
//        int distance = 3;
//        Integer[] arr = {7,1,4,6,null,5,3,null,null,null,null,null,2};
//        int distance = 3;
        Integer[] arr = {15,66,55,97,60,12,56,null,54,null,49,null,9,null,null,null,null,null,90};
        int distance = 5;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.countPairs(root, distance);
        System.out.println(ret);
    }

}
