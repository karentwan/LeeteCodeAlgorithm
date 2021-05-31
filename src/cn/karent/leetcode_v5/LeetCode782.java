package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 变为棋盘
 * @author wan
 * @date 2021.05.31
 ********************************************/
public class LeetCode782 {

    public int movesToChessboard(int[][] board) {
        int N = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] rows : board) {
            int code = 0;
            for (int row : rows) {
                code = (code << 1) + row;
            }
            map.put(code, map.getOrDefault(code, 0) + 1);
        }
        int k1 = analyze(map, N);
        if( k1 == -1) return -1;
        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int code = 0;
            for (int j = 0; j < N; j++) {
                code = (code << 1) + board[j][i];
            }
            map.put(code, map.getOrDefault(code, 0)+1);
        }
        int k2 = analyze(map, N);
        return k2 >= 0 ? k1 + k2 : -1;
    }

    private int analyze(Map<Integer, Integer> map, int n) {
        if( map.size() != 2) return -1;
        List<Integer> list = new ArrayList<>(map.keySet());
        int k1 = list.get(0);
        int k2 = list.get(1);
        // k1和k2的数量一人占一半
        int v1 = map.get(k1);
        int v2 = map.get(k2);
        if( !(v1 == n / 2 && v2 == (n+1)/2) && !(v2 == n/2 && v1 == (n+1)/2)) return -1;
        int mask = (1 << n) - 1;
        // 如果两个key不是相反的, 则不可能
        if( (k1 ^ k2 & mask) != mask) return -1;
        int s1 = 0xaaaaaaaa;  // 情况1 1010
        int s2 = 0x55555555;  // 情况2 0101
        int ret = Integer.MAX_VALUE;
        int t1 = Integer.bitCount(k1 ^ s1 & mask) / 2;
        int t2 = Integer.bitCount(k1 ^ s2 & mask) / 2;
        // 计算需要交换的次数
        if( n % 2 == 0) {  // 如果为偶数
            ret = Math.min(t1, t2);
        } else {
            int ones = Integer.bitCount( k1 & mask);
            if( ones == (n + 1) / 2) {  // 1占多数
                ret = t2;
            } else {
                ret = t1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode782 lc = new LeetCode782();
//        int[][] board = {{0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}};
//        int[][] board = {{1,1,0},{0,0,1},{0,0,1}};
        int[][] board = {{1,0,0},{0,1,1},{1,0,0}};
        int ret = lc.movesToChessboard(board);
        System.out.println(ret);
    }

}
