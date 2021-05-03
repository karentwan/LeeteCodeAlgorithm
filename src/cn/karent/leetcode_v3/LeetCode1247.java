package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 交换字符使得字符串相同
 * @author wan
 * @date 2021.04.15
 */
public class LeetCode1247 {

    public int minimumSwap(String s1, String s2) {
        int x = 0, y = 0;
        for (int i = 0; i < s1.length(); i++) {
            if( s1.charAt(i) != s2.charAt(i) ) {
                if( s2.charAt(i) == 'x') x++;
                else y++;
            }
        }
        // 奇数加偶数一定为奇数
        if( (x + y) % 2 != 0) return -1;
        return x / 2 + y / 2 + (x % 2) * 2;
    }

    public static void main(String[] args) {
        LeetCode1247 lc = new LeetCode1247();
//        String s1 = "xx";
//        String s2 = "yy";
//        String s1 = "xy";
//        String s2 = "yx";
//        String s1 = "xx";
//        String s2 = "xy";
        String s1 = "xxyyxyxyxx";
        String s2 = "xyyxyxxxyx";
        int ret = lc.minimumSwap(s1, s2);
        System.out.println(ret);
    }

}
