package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;


/**
 * 把数组排成最小的数
 * @author wan
 * @date 2021.04.04
 */
public class Offer45 {


    public String minNumber(int[] nums) {
        Integer[] tmps = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmps[i] = nums[i];
        }
        Arrays.sort(tmps, (k1, k2) -> {
            String s1 = String.valueOf(k1);
            String s2 = String.valueOf(k2);
            String t1 = s1 + s2;
            String t2 = s2 + s1;
            return t1.compareTo(t2);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(tmps[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
//        int[] nums = {3,30,34,5,9};
//        int[] nums = {12,121};
//        int[] nums = {1440,7548,4240,6616,733,4712,883,8,9576};
        Offer45 offer = new Offer45();
        String s = offer.minNumber(nums);
        System.out.println(s);
    }

}
