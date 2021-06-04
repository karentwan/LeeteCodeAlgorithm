package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 切割后面积最大的蛋糕
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class LeetCode1465 {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int[] heights = new int[horizontalCuts.length + 1];
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int last = 0, i = 0; i < horizontalCuts.length;
             last = horizontalCuts[i], i++) {
            heights[i] = horizontalCuts[i] - last;
        }
        heights[horizontalCuts.length] = h - horizontalCuts[horizontalCuts.length-1];
        int[] weights = new int[verticalCuts.length+1];
        for (int last = 0, i = 0; i < verticalCuts.length;
             last = verticalCuts[i], i++) {
            weights[i] = verticalCuts[i] - last;
        }
        weights[verticalCuts.length] = w - verticalCuts[verticalCuts.length-1];
        Arrays.sort(weights);
        Arrays.sort(heights);
        long ret = weights[weights.length-1] * 1L * heights[heights.length-1];
        int MOD = ((int) (1e9 + 7));
        return ((int) (ret % MOD));
    }

    public static void main(String[] args) {
        LeetCode1465 lc = new LeetCode1465();
//        int h = 5;
//        int w = 4;
//        int[] horizontalCuts = {1, 2, 4};
//        int[] verticalCuts = {1, 3};
        int h = 5;
        int w = 4;
        int[] horizontalCuts = {3,1};
        int[] verticalCuts = {1};
        int ret = lc.maxArea(h, w, horizontalCuts, verticalCuts);
        System.out.println(ret);
    }

}
