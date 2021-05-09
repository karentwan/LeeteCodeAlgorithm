package cn.karent.leetcode_v4.weeklycontest240;

import java.util.*;

/********************************************
 * description: 下标对中的最大距离
 * @author wan
 * @date 2021.05.09
 ********************************************/
public class Algo5751 {

    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int ret = 0;
        while (i < nums1.length && j < nums2.length) {
            while (j < nums2.length && nums2[j] >= nums1[i]) j++;
            i++;
            ret = Math.max(ret, j - i);
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5751 lc = new Algo5751();
//        int[] nums1 = {55, 30, 5, 4, 2};
//        int[] nums2 = {100, 20, 10, 10, 5};
        int[] nums1 = {2,2,2};
        int[] nums2 = {10,10,1};
        int ret = lc.maxDistance(nums1, nums2);
        System.out.println(ret);
    }

}
