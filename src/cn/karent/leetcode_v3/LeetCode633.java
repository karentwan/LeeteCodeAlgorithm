package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 平方数之和
 * @author wan
 * @date 2021.04.28
 ********************************************/
public class LeetCode633 {

    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = ((int) Math.sqrt(c));
        while (l <= r) {
            int m = l * l + r * r;
            if( m == c) return true;
            else if( m < c) l++;
            else r--;
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode633 lc = new LeetCode633();
        int c = 3;
        boolean ret = lc.judgeSquareSum(c);
        System.out.println(ret);
    }

}
