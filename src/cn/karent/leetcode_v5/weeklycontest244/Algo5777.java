package cn.karent.leetcode_v5.weeklycontest244;

import java.util.*;

/********************************************
 * description: 使数组元素相等的减少操作次数
 * @author wan
 * @date 2021.06.06
 ********************************************/
public class Algo5777 {

    public int reductionOperations(int[] nums) {
        Integer[] tmps = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmps[i] = nums[i];
        }
        Arrays.sort(tmps, (k1, k2) -> k2 - k1);
        int ret = 0;
        int i = 0;
        while ( i < tmps.length) {
            i++;
            while (i < tmps.length && Integer.compare(tmps[i], tmps[i-1]) == 0)
                i++;
            if( i < tmps.length) ret += i;
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5777 lc = new Algo5777();
//        int[] arr = {5, 1, 3};
        int[] arr = {1,1,2,2,3};
        int ret = lc.reductionOperations(arr);
        System.out.println(ret);
    }

}
