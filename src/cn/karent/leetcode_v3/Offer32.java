package cn.karent.leetcode_v3;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 从上到下打印二叉树 二
 * @author wan
 * @date 2021.04.22
 ********************************************/
public class Offer32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if( root == null) return new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        List<List<Integer>> rets = new ArrayList<>();
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> ret = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                ret.add(node.val);
                if( node.left != null) que.offer(node.left);
                if( node.right != null) que.offer(node.right);
            }
            rets.add(ret);
        }
        return rets;
    }

    public static void main(String[] args) {
        Offer32 lc = new Offer32();
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<List<Integer>> rets = lc.levelOrder(root);
        System.out.println(rets);
    }

}
