package cn.karent.leetcode_v7;

import cn.karent.util.TreeNode;
import java.util.*;

/******************************************
 * 最大层内元素和
 * @author wan
 * @date 2022.07.31 09:54
 ******************************************/
public class LeetCode1161 {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        int ret = 0, level = 1;
        long sum = Long.MIN_VALUE;
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            long val = 0l;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                val += node.val;
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
            if (val > sum) {
                ret = level;
                sum = val;
            }
            level ++;
        }
        return ret;
    }


    public static void main(String[] args) {
        LeetCode1161 lc = new LeetCode1161();
    }

}
