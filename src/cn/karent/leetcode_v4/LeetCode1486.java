package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 数组异或操作
 * @author wan
 * @date 2021.05.07
 ********************************************/
public class LeetCode1486 {

    public int xorOperation(int n, int start) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = ret ^ (start + 2 * i);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1486 lc = new LeetCode1486();
        int n = 1;
        int start = 7;
        int ret = lc.xorOperation(n, start);
        System.out.println(ret);
    }

}
