package cn.karent.leetcode_v4;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/********************************************
 * description: 将数组分成和相等的三个部分
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1013 {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }
        if( sum % 3 != 0) return false;
        int part = sum / 3;
        int cnt = 0;
        int wnd = 0;
        for (int item : arr) {
            wnd += item;
            if( wnd == part) {
                cnt++;
                wnd = 0;
            }
        }
        return cnt >= 3;
    }

    public static void main(String[] args) {
        LeetCode1013 lc = new LeetCode1013();
        int[] arr = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        int[] arr1 = {0,2,1,-6,6,7,9,-1,2,0,1};
        int[] arr2 = {3,3,6,5,-2,2,5,1,-9,4};
        int[] arr3 = {0,0,0,0};
        LeetCodeUtil.run((params)->{
            boolean ret = lc.canThreePartsEqualSum(params);
            System.out.println(ret);
        }, arr, arr1, arr2, arr3);
    }

}
