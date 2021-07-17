package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 连续子数组的最大和
 * @author wan
 * @date 2021.07.17
 ***********************************************/
public class Offer42 {

    public int maxSubArray(int[] nums) {
        int wnd = Integer.MIN_VALUE / 2;
        int ret = Integer.MIN_VALUE/2;
        for(int i = 0; i < nums.length; i++) {
            wnd = Math.max(wnd + nums[i], nums[i]);
            ret = Math.max(ret, wnd);
        }
        return ret;
    }

    public static void main(String[] args) {
        Offer42 lc = new Offer42();
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ret = lc.maxSubArray(arr);
        System.out.println(ret);
    }

}
