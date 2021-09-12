package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 有效的括号字符串
 * @author wan
 * @date 2021.09.12
 ***********************************************/
public class LeetCode678 {

    // 贪心
    public boolean checkValidString1(String s) {
        int min = 0, max = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if( chs[i] == '(') {
                min++; max++;
            } else if( chs[i] == '*') {
                min--;max++;
            } else {
                min--;max--;
            }
            if( max < 0) return false;
            min = Math.max(min, 0);
        }
        return min == 0;
    }

    /**
     *  这个跟判断回文串类似
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        // 边界条件, 只有一个元素时, 只有*符合
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if( chs[i] == '*') {
                dp[i][i] = true;
            }
        }
        // 只有两个元素时, (), (*, *), **符合
        for (int i = 1; i < chs.length; i++) {
            char a = chs[i-1], b = chs[i];
            dp[i-1][i] = (a == '(' || a == '*') && ( b == ')' || b == '*');
        }
        // 开始遍历
        for (int i = chs.length-3; i >= 0; i --) {
            for (int j = i+2; j < chs.length; j++) {
                char a = chs[i], b = chs[j];
                dp[i][j] = dp[i+1][j-1] && (
                        (a == '(' || a == '*') && ( b == ')' || b == '*')
                        );
                for (int k = i; k < j; k++) {
                    dp[i][j] = dp[i][j] || dp[i][k] && dp[k+1][j];
                }
            }
        }
        return dp[0][chs.length-1];
    }

    public static void main(String[] args) {

    }

}
