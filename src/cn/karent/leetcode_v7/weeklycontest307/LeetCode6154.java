package cn.karent.leetcode_v7.weeklycontest307;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.TreeNode;
import java.util.*;

/******************************************
 * 感染二叉树需要的总时间
 * @author wan
 * @date 2022.08.21 10:47
 ******************************************/
public class LeetCode6154 {

    public int amountOfTime(TreeNode root, int start) {
        // 先构建图
        Map<Integer, List<Integer>> edges = new HashMap<>();
        Deque<TreeNode> que = new ArrayDeque<>();
        que.offerLast(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.pollFirst();
                if (node.left != null) {
                    edges.computeIfAbsent(node.val, k->new ArrayList<>()).add(node.left.val);
                    edges.computeIfAbsent(node.left.val, k -> new ArrayList<>()).add(node.val);
                    que.offerLast(node.left);
                }
                if (node.right != null) {
                    edges.computeIfAbsent(node.val, k -> new ArrayList<>()).add(node.right.val);
                    edges.computeIfAbsent(node.right.val, k -> new ArrayList<>()).add(node.val);
                    que.offerLast(node.right);
                }
            }
        }
        Set<Integer> vis = new HashSet<>();
        int time = 0;
        Deque<Integer> q1 = new ArrayDeque<>();
        q1.offerLast(start);
        vis.add(start);
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                Integer node = q1.pollFirst();
                List<Integer> edge = edges.getOrDefault(node, new ArrayList<>());
                for (Integer e : edge) {
                    if (!vis.contains(e)) {
                        vis.add(e);
                        q1.offerLast(e);
                    }
                }
            }
            time++;
        }
        return time - 1;
    }

    public static void main(String[] args) {
        LeetCode6154 lc = new LeetCode6154();
//        Integer[] arr = {1, 5, 3, null, 4, 10, 6, 9, 2};
//        int start = 3;
        Integer[] arr = {1};
        int start = 1;
//        Integer[] arr = {1, 2, null, 3, null, 4, null, 5};
//        int start = 3;
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        System.out.println(lc.amountOfTime(root, start));
    }

}
