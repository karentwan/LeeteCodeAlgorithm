package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.TreeNode;

/*******************************************
 * @author wan
 * @date: 2022-03-19 10:15
 * @description: 根据二叉树创建字符串
 *******************************************/
public class LeetCode606 {

    public String tree2str(TreeNode root) {
        if (root == null) return "()";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String left = tree2str(root.left);
        String right = tree2str(root.right);
        if (left.equals("()") && right.equals("()")) {}
        else if (left.equals("()") && !right.equals("()")) {
            sb.append("()").append("(").append(right).append(")");
        } else if (!left.equals("()") && right.equals("()")) {
            sb.append("(").append(left).append(")");
        } else {
            sb.append("(").append(left).append(")").append("(").append(right).append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode606 lc = new LeetCode606();
//        Integer[] arr = {1,2,3,4};
        Integer[] arr = {1,2,3,null,4};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        System.out.println(lc.tree2str(root));
    }
}
