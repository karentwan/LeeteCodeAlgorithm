package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 变为棋盘
 * @author wan
 * @date 2022.08.23 08:37
 ******************************************/
public class LeetCode782 {

    public int movesToChessboard(int[][] board) {
        int n = board.length;
        int rowMask = 0, colMask = 0;
        // 检查棋盘的第一行与第一列
        for (int i = 0; i < n; i++) {
            rowMask |= (board[0][i] << i);
            colMask |= (board[i][0] << i);
        }
        int reverseRowMask = ((1 << n)-1) ^ rowMask;
        int reverseColMask = ((1 << n)-1) ^ colMask;
        int rowCnt = 0, colCnt = 0;
        for (int i = 0; i < n; i++) {
            int currRowMask = 0;
            int currColMask = 0;
            for (int j = 0; j < n; j++) {
                currRowMask |= (board[i][j] << j);
                currColMask |= (board[j][i] << j);
            }
            // 检测每一行的状态是否合法
            if (currRowMask != rowMask && currRowMask != reverseRowMask) {
                return -1;
            } else if (currRowMask == rowMask) {
                rowCnt++;
            }
            // 检测每一列的状态是否合法
            if (currColMask != colMask && currColMask != reverseColMask) {
                return -1;
            } else if (currColMask == colMask) {
                colCnt++;
            }
        }
        int rowMoves = getMoves(rowMask, rowCnt, n);
        int colMoves = getMoves(colMask, colCnt, n);
        return (rowMoves == -1 || colMoves == -1) ? -1 : (rowMoves + colMoves);
    }

    private int getMoves(int mask, int cnt, int n) {
        int ones = Integer.bitCount(mask);
        if ((n & 1) == 1) {
            // abs(n-2*ones): 判断第一行是否满足1的个数和0的个数相差为1(判断列)
            // abs(n - 2*cnt): 判断跟第一行相同的数目和与第一行不同的个数是否相差为1
            if (Math.abs(n - 2*ones) != 1 || Math.abs(n - 2*cnt) != 1) {
                return -1;
            }
            // 当0的个数多于1的个数, 只有一种情况, 那就是010101...01,这个时候计算就只需要所有1的个数
            // 减去已经排好位置的1的个数就是需要改变的个数
            if (ones == (n >> 1)) {
                return n / 2 - Integer.bitCount(mask & 0xAAAAAAAA);
            } else {
                return (n+1) /2 - Integer.bitCount(mask & 0x55555555);
            }
        } else {
            if (ones != (n >> 1) || cnt != (n >> 1)) {
                return -1;
            }
            int cnt0 = n/2 - Integer.bitCount(mask & 0xAAAAAAAA);
            int cnt1 = n/2 - Integer.bitCount(mask & 0x55555555);
            return Math.min(cnt0, cnt1);
        }
    }

    public static void main(String[] args) {
        LeetCode782 lc = new LeetCode782();
    }

}
