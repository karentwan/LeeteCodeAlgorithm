package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;

/**
 * 二叉树的中序遍历
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rets = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode p = root;
        while (p != null || !st.isEmpty()) {
            while (p != null) {
                st.push(p);
                p = p.left;
            }
            p = st.pop();
            rets.add(p.val);
            p = p.right;
        }
        return rets;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,null,2,3};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        LeetCode94 lc = new LeetCode94();
        List<Integer> rets = lc.inorderTraversal(root);
        System.out.println(rets);
    }

}
