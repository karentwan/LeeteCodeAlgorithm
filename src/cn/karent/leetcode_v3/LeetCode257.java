package cn.karent.leetcode_v3;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 二叉树的所有路径
 * @author wan
 * @date 2021.04.30
 ********************************************/
public class LeetCode257 {

    public void dfs(TreeNode root, List<String> rets, List<Integer> ret) {
        if( root == null) return;
        ret.add(root.val);
        if( root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (Integer item : ret) {
                sb.append(item + "->");
            }
            if( sb.length() > 0) {
                rets.add(sb.substring(0, sb.length()-2));
            }
            ret.remove(ret.size()-1);
            return;
        }
        dfs(root.left, rets, ret);
        dfs(root.right, rets, ret);
        ret.remove(ret.size()-1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rets = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        dfs(root, rets, ret);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode257 lc = new LeetCode257();
        Integer[] arr = {1,2,3,null,5};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<String> rets = lc.binaryTreePaths(root);
        for (String ret : rets) {
            System.out.println(ret);
        }
    }

}
