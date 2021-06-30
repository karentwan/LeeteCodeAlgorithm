package cn.karent.leetcode_v5;

import java.util.*;
import cn.karent.util.*;

/***********************************************
 * description: 序列化二叉树
 * @author wan
 * @date 2021.06.30
 ***********************************************/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if( root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        sb.append(root.val + ",");
        while (!que.isEmpty()) {
            int size = que.size();
            StringBuilder tmp = new StringBuilder();
            boolean flag = false;
            for (int i = 0; i < size; i++) {
                TreeNode p = que.poll();
                if( p.left != null) {
                    tmp.append(p.left.val + ",");
                    que.offer(p.left);
                    flag = true;
                } else {
                    tmp.append("null,");
                }
                if( p.right != null) {
                    tmp.append(p.right.val + ",");
                    que.offer(p.right);
                    flag = true;
                } else {
                    tmp.append("null,");
                }
            }
            if( flag ) sb.append(tmp.toString());
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        strs[0] = strs[0].substring(1, strs[0].length());
        int n = strs.length;
        strs[n-1] = strs[n-1].substring(0, strs[n-1].length()-1);
        if( strs[0].length() == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        for (int i = 1; i < n; i+=2) {
            TreeNode p = que.poll();
            if( !strs[i].equals("null")) {
                p.left = new TreeNode(Integer.parseInt(strs[i]));
                que.offer(p.left);
            }
            if( i + 1 < n && !strs[i+1].equals("null")) {
                p.right = new TreeNode(Integer.parseInt(strs[i+1]));
                que.offer(p.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
//        Integer[] arr = {1,2,3,null,null,4,5};
        Integer[] arr = {};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        Codec lc = new Codec();
        String ret = lc.serialize(root);
        System.out.println(ret);
        TreeNode retRoot = lc.deserialize(ret);
        LeetCodeUtil.levelTraverse(retRoot);
    }

}
