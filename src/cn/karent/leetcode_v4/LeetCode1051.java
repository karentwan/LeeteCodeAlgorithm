package cn.karent.leetcode_v4;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/********************************************
 * description: 高度检查器
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1051 {

    public int heightChecker(int[] heights) {
        int[] tmps = Arrays.copyOf(heights, heights.length);
        Arrays.sort(tmps);
        int ret = 0;
        for (int i = 0; i < heights.length; i++) {
            if( heights[i] != tmps[i]) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1051 lc = new LeetCode1051();
        int[] arr = {1, 1, 4, 2, 1, 3};
        int[] arr1 = {5,1,2,3,4};
        int[] arr2 = {1,2,3,4,5};
        LeetCodeUtil.run((param)->{
            int ret = lc.heightChecker(param);
            System.out.println(ret);
        }, arr, arr1, arr2);
    }

}
