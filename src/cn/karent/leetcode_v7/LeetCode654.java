package cn.karent.leetcode_v7;

import java.util.*;
import cn.karent.util.*;

/******************************************
 * 最大二叉树
 * @author wan
 * @date 2022.08.20 08:40
 ******************************************/
public class LeetCode654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int idx = 0, ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > ret) {
                idx = i;
                ret = nums[i];
            }
        }
        TreeNode root = new TreeNode(ret);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, idx));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, idx+1, nums.length));
        return root;
    }

    public static void main(String[] args) {
        LeetCode654 lc = new LeetCode654();
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = lc.constructMaximumBinaryTree(nums);

        LeetCodeUtil.levelTraverse(root);
    }

}
