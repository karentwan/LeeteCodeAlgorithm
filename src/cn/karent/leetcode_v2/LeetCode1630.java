package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 等差子数组
 */
public class LeetCode1630 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> rets = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int left = l[i];
            int right = r[i];
            List<Integer> tmps = new ArrayList<>();
            for (int j = left; j <= right ; j++) {
                tmps.add(nums[j]);
            }
            Collections.sort(tmps);
            boolean flag = true;
            int tmp = 0;
            for (int j = 0; j < tmps.size() && flag; j++) {
                if( j > 1 && tmps.get(j) - tmps.get(j-1) != tmp) {
                    flag = false;
                }
                if( j > 0) {
                    tmp = tmps.get(j) - tmps.get(j-1);
                }
            }
            rets.add(flag);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1630 lc = new LeetCode1630();
//        int[] nums = {4,6,5,9,3,7};
//        int[] l = {0,0,2};
//        int[] r = {2,3,5};
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        List<Boolean> rets = lc.checkArithmeticSubarrays(nums, l, r);
        System.out.println(rets);
    }

}
