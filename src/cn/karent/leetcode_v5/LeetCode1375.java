package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 灯泡开关 三
 * @author wan
 * @date 2021.06.03
 ********************************************/
public class LeetCode1375 {

    public int numTimesAllBlue(int[] light) {
        int ret = 0;
        int max = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if( max == (i + 1)) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1375 lc = new LeetCode1375();
//        int[] arr = {2, 1, 3, 5, 4};
        int[] arr = {3,2,4,1,5};
        int ret = lc.numTimesAllBlue(arr);
        System.out.println(ret);
    }

}
