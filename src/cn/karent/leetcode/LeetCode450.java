package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 删除二叉搜索树中的节点
 */
public class LeetCode450 {

    private int successor(TreeNode root) {
        root = root.right;
        while( root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    private int predecessor(TreeNode root) {  // 最大
        root = root.left;
        while( root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if( root == null) {
            return null;
        }
        if( root.val == key) {  // 删除
            // 分三种情况删除
            // 1. 如果该节点是叶子节点, 那么直接删除
            if( root.left == null && root.right == null) {
                root = null;
            // 2. 该节点的右子节点不为空, 找右子节点最小的元素替换该节点的元素
            // 然后删除那个元素
            } else if( root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            // 3. 该节点左子树不为空, 找左子树最大元素替换该元素
            // 然后删除左子树最大元素
            } else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        } else if( key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
