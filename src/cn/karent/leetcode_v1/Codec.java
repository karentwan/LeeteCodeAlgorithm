package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 序列化和反序列化
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        sb.append("[");
        if( root == null) {
            sb.append("]");
            return sb.toString();
        }
        sb.append(root.val);
        sb.append(",");
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = que.poll();
                if( node.left != null) {
                    que.offer(node.left);
                    sb.append(node.left.val);
                    sb.append(",");
                } else {
                    sb.append("null");
                    sb.append(",");
                }
                if( node.right != null) {
                    que.offer(node.right);
                    sb.append(node.right.val);
                    sb.append(",");
                } else {
                    sb.append("null");
                    sb.append(",");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> que = new LinkedList<>();
        String tmp = data.replace("[", "").replace("]", "");
        if( tmp.length() == 0) {
            return null;
        }
        String[] chs = tmp.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(chs[0]));
        que.offer(root);
        int i = 1;
        while (i < chs.length) {
            TreeNode node = que.poll();
            if( !chs[i].equals("null") ) {
                TreeNode left = new TreeNode(Integer.valueOf(chs[i]));
                que.offer(left);
                node.left = left;
            }
            i++;
            if (i < chs.length && !chs[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(chs[i]));
                que.offer(right);
                node.right = right;
            }
            i++;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
//        Integer[] arr = {2,1,3};
//        Integer[] arr = {};
        Integer[] arr = {3,1,4,null,2};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        String serial = codec.serialize(root);
        System.out.println(serial);
        TreeNode ret = codec.deserialize(serial);
        LeetCodeUtil.levelTraverse(ret);
    }

}
