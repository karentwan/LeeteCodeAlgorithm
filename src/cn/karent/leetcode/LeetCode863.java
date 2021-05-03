package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.TreeNode;
import cn.karent.util.LeetCodeUtil;

/**
 * 二叉树中所有距离为K的结点
 */
public class LeetCode863 {

    private Map<TreeNode, TreeNode> parent = new HashMap<>();

    private void dfs(TreeNode node, TreeNode parent) {
        if( node == null) {
            return;
        }
        this.parent.put(node, parent);
        dfs(node.left, node);
        dfs(node.right, node);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> rets = new ArrayList<>();
        dfs(root, null);
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(target);
        visited.add(target);
        while( !que.isEmpty() ) {
            if( K == 0) {
                while( !que.isEmpty() ) {
                    rets.add(que.poll().val);
                }
            }
            int size = que.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if( node.left != null && !visited.contains(node.left)) {
                    que.offer(node.left);
                    visited.add(node.left);
                }
                if( node.right != null && !visited.contains(node.right)) {
                    que.offer(node.right);
                    visited.add(node.right);
                }
                TreeNode p = parent.get(node);
                if( p != null && !visited.contains(p)) {
                    que.offer(p);
                    visited.add(p);
                }
            }
            K--;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode863 lc = new LeetCode863();
        Integer[] arr = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        List<Integer> rets = lc.distanceK(root, root.left, 2);
        for(int item : rets) {
            System.out.print(item + " ");
        }
    }
}
