package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 甲板上的战舰
 * @author wan
 * @date 2021.07.02
 ***********************************************/
public class LeetCode419 {

    public int countBattleships(char[][] board) {
        int ret = 0;
        int m = board.length;
        if( m == 0) return ret;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if( board[i][j] == '.') continue;
                if( i > 0 && board[i-1][j] == 'X') continue;
                if( j > 0 && board[i][j-1] == 'X') continue;
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode419 lc = new LeetCode419();

    }

}
