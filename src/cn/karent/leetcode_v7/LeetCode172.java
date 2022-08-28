package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 阶乘后的零
 * @author wan
 * @date 2022.08.28 09:56
 ******************************************/
public class LeetCode172 {

    public int trailingZeroes1(int n) {
        int ret = 0;
        for (int i = 5; i <= n; i += 5) {
            for (int j = i; j % 5 == 0; j /= 5) {
                ret++;
            }
        }
        return ret;
    }

    public int trailingZeroes(int n) {
        int ret = 0;
        while (n != 0) {
            n /= 5;
            ret += n;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode172 lc = new LeetCode172();
    }

}
