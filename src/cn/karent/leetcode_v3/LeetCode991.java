package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 坏了的计算器
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode991 {

    // 逆向思维, X -> Y 不好算, 但是Y -> X比较好算
    public int brokenCalc(int X, int Y) {
        int ret = 0;
        // Y+1+1/2  = Y/2+1 前面需要三步, 后面需要两步
        // Y必须是偶数除以2, 因为X乘以2不可能得到奇数
        while (Y > X) {
            ret++;
            if( Y % 2 == 0) Y /= 2;
            else Y++;
        }
        return ret + X - Y;
    }

    public static void main(String[] args) {
        LeetCode991 lc = new LeetCode991();
        int x = 5;
        int y = 8;
        int ret = lc.brokenCalc(x,y);
        System.out.println(ret);
    }

}
