package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉树后序遍历
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode prev = null;
        List<Integer> rets = new ArrayList<>();
        while ( p != null || !st.isEmpty()) {
            while (p != null) {
                st.push(p);
                p = p.left;
            }
            p = st.peek();
            p = p.right;
            if( p == null || p == prev) {
                p = st.pop();
                rets.add(p.val);
                prev = p;
                p = null;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2,3};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        LeetCode145 lc = new LeetCode145();
        List<Integer> rets = lc.postorderTraversal(root);
        System.out.println(rets);
    }

}
