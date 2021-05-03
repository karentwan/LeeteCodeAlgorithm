package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 整数反转
 * @author wan
 * @date 2021.05.03
 ********************************************/
public class LeetCode7 {

    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        int ret = 0;
        x = Math.abs(x);
        int t = 0;
        int mod = 0;
        while (x > 0) {
            mod = x % 10;
            t = ret * 10 + mod;
            if( (t - mod) / 10 != ret) return 0;
            ret = t;
            x /= 10;
        }
        return ret * sign;
    }

    public static void main(String[] args) {
        LeetCode7 lc = new LeetCode7();
//        int x = 123;
        int x = -123;
//        int x = 120;
//        int x = 0;
//        int x = -2147483412;
//        int x = 1534236469;
        int ret = lc.reverse(x);
        System.out.println(ret);
    }

}
