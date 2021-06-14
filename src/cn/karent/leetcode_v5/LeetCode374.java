package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 猜数字大小
 * @author wan
 * @date 2021.06.14
 ********************************************/
public class LeetCode374 extends GuessGame{

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int m = l + (r - l)/2;
            int t = guess(m);
            if( t == 0) return m;
            else if( t > 0) r = m-1;
            else l = m+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode374 lc = new LeetCode374();
        int n = 10;
        int ret = lc.guessNumber(n);
        System.out.println(ret);
    }

}

class GuessGame {
    public int guess(int num) {
        return num - 6;
    }
}
