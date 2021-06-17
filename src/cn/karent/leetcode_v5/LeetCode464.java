package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 我能赢吗
 * @author wan
 * @date 2021.06.17
 ********************************************/
public class LeetCode464 {

    private Boolean[] memo = null;

    private boolean dfs(int max, int dt, int state) {
        if( memo[state] != null) return memo[state];
        for (int i = 1; i <= max; i++) {
            int s = 1 << (i - 1);
            if( (s & state) != 0) continue;
            if( dt - i <= 0 || !dfs(max, dt - i, state | s)) {
                memo[state] = true;
                return true;
            }
        }
        memo[state] = false;
        return false;
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if( maxChoosableInteger >= desiredTotal) return true;
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if( sum < desiredTotal) return false;
        memo = new Boolean[1 << maxChoosableInteger];
        return dfs(maxChoosableInteger, desiredTotal, 0);
    }

    public static void main(String[] args) {

    }

}
