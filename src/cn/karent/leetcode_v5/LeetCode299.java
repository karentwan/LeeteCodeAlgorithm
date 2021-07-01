package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 猜数字游戏
 * @author wan
 * @date 2021.07.01
 ***********************************************/
public class LeetCode299 {

    public String getHint(String secret, String guess) {
        char[] src = secret.toCharArray();
        char[] dst = guess.toCharArray();
        int[] cache1 = new int[10];
        int[] cache2 = new int[10];
        int a = 0;
        for (int i = 0; i < src.length; i++) {
            cache1[src[i] - '0']++;
            cache2[dst[i] - '0']++;
            if( src[i] == dst[i]) {
                a++;
            }
        }
        int b = 0;
        for (int i = 0; i < 10; i++) {
            if( cache1[i] > 0 && cache2[i] > 0)
                b += Math.min(cache1[i], cache2[i]);
        }
        return a + "A" + (b - a) + "B";
    }

    public static void main(String[] args) {
        LeetCode299 lc = new LeetCode299();
        String secret = "1123";
        String guess = "0111";
        String ret = lc.getHint(secret, guess);
        System.out.println(ret);
    }

}
