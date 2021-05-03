package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 单调递增的数字
 * @author wan
 * @date 2021.04.08
 */
public class LeetCode738 {

    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] chs = s.toCharArray();
        int i = 1;
        while (i < s.length() && chs[i-1] <= chs[i]) {
            i++;
        }
        if( i < s.length() ) {
            while (i > 0 && chs[i-1] > chs[i]) {
                chs[i-1]--;
                i--;
            }
            for (i += 1; i < s.length(); i++) {
                chs[i] = '9';
            }
        }
        return Integer.parseInt(new String(chs));
    }

    public static void main(String[] args) {
        LeetCode738 lc = new LeetCode738();
        int n = 332;
        int ret = lc.monotoneIncreasingDigits(n);
        System.out.println(ret);
    }

}
