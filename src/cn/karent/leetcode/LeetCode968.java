package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 监控二叉树
 */
public class LeetCode968 {

    final int INFINITY = Integer.MAX_VALUE/4;

    class Result {

        public int cover = 0;
        public int uncover = 0;
        public int camera = 0;

        public Result() {}

        public Result(int cover, int uncover, int camera) {
            this.cover = cover;
            this.uncover = uncover;
            this.camera = camera;
        }
    }

    public Result dynamicProgramming(TreeNode root) {
        Result ret = new Result();
        if( root == null) {
            ret.camera = INFINITY;
            return ret;
        }
        Result left = dynamicProgramming(root.left);
        Result right = dynamicProgramming(root.right);
        // cover uncover camera
        // camera状态是至少其中一个子节点没有被覆盖
        ret.camera = left.uncover + right.cover;
        ret.camera = Math.min(ret.camera, left.uncover + right.camera);
        ret.camera = Math.min(ret.camera, right.uncover + left.cover);
        ret.camera = Math.min(ret.camera, right.uncover + left.camera);
        ret.camera = Math.min(ret.camera, right.uncover + left.uncover);
        ret.camera++;
        // uncover, 两个子节点一定是覆盖, 如果子节点是相机状态, 该节点不可能未覆盖
        ret.uncover = left.cover + right.cover;
        // cover, 两个子节点至少有一个相机或者两个都有相机
        ret.cover = left.camera + right.cover;
        ret.cover = Math.min(ret.cover, right.camera + left.cover);
        ret.cover = Math.min(ret.cover, right.camera + left.camera);
        return ret;
    }

    public int minCameraCover(TreeNode root) {
        Result ret = dynamicProgramming(root);
        return Math.min(ret.cover, ret.camera);
    }

    public static void main(String[] args) {
        LeetCode968 lc = new LeetCode968();
//        Integer[] arr = {0,0,null, 0,0};
//        Integer[] arr = {0,0,null,0,null,0,null,null,0};
//        Integer[] arr = {0,0,null,null,0,0,null,null,0,0};
//        Integer[] arr = {0,0,0};
//        Integer[] arr = {0,0,null,0,0};
        Integer[] arr = {0};
        TreeNode root = LeetCodeUtil.arr2tree(arr);
        int ret = lc.minCameraCover(root);
        System.out.println(ret);
    }
}
