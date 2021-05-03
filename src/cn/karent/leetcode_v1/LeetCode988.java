package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 从叶节点开始的最小字符串
 */
public class LeetCode988 {

    private char[] letter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                             'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                             's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private String ret = null;

    private int compare(String s1, String s2) {
        if( s1 == null) {
            return 1;
        }
        int i = s1.length()-1;
        int j = s2.length()-1;
        while( i >= 0 && j >= 0 && s1.charAt(i) == s2.charAt(j)) {
            i--;
            j--;
        }
        if( i < 0 && j < 0) {
            return 0;
        }
        if( i < 0) {
            return -1;
        }
        if( j < 0) {
            return 1;
        }
        return s1.charAt(i) - s2.charAt(j);
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if( root == null) {
            return;
        }
        sb.append(letter[root.val]);
        if( root.left == null && root.right == null) {
            String tmp = sb.toString();
            if( compare(ret, tmp) > 0) {
                ret = tmp;
            }
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        dfs(root.left, sb);
        dfs(root.right, sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        StringBuilder tmp = new StringBuilder(ret);
        return tmp.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode988 lc = new LeetCode988();
//        Integer[] arr = {25, 1, 3, 1, 3, 0, 2};
        Integer[] arr = {0,1,2,3,4,3,4};
//        Integer[] arr = {2,2,1,null,1,0,null,0};
//        Integer[] arr = {0,null,1};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        String ret = lc.smallestFromLeaf(root);
        System.out.println(ret);
    }
}
