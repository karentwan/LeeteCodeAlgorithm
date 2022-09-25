package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 旋转数字
 * @author wan
 * @date 2022.09.25 11:03
 ******************************************/
public class LeetCode788 {

    private boolean isGood(int n) {
        int[] rotate = {0,0,1,-1,-1,1,1,-1,0,1};
        boolean ret = false;
        while (n > 0) {
            int mod = n % 10;
            if (rotate[mod] == -1) return false;
            if (rotate[mod] == 1) ret = true;
            n /= 10;
        }
        return ret;
    }

    public int rotatedDigits(int n) {
        int ret = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode788 lc = new LeetCode788();
        int n = 10;
        System.out.println(lc.rotatedDigits(n));
    }

}
