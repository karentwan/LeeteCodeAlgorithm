package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 可以攻击国王的皇后
 * @author wan
 * @date 2021.05.31
 ********************************************/
public class LeetCode1222 {
    /*
    private int[] rows = {-1, 1, 0, 0, -1, 1,-1, 1};
    private int[] cols = { 0, 0,-1, 1, -1, 1, 1,-1};

    final int KING = 2;
    final int QUEEN = 1;

    Map<String, Boolean> memo = new HashMap<>();

    private boolean dfs(int[][] chessBoard, int x, int y, int m, int n) {
        if( x < 0 || y < 0 || x >= m || y >= n || chessBoard[x][y] == QUEEN) return false;
        if( chessBoard[x][y] == KING) return true;
        String key = x + "-" + y;
        if( memo.containsKey(key) ) return memo.get(key);
        for (int i = 0; i < 8; i++) {
            int dx = rows[i];
            int dy = cols[i];
            if( dfs(chessBoard, x + dx, y + dy, m, n)) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] chessBoard = new int[8][8];
        for (int[] queen : queens) {
            chessBoard[queen[0]][queen[1]] = QUEEN;
        }
        chessBoard[king[0]][king[1]] = KING;
        List<List<Integer>> rets = new ArrayList<>();
        for (int[] queen : queens) {
            if( dfs(chessBoard, queen[0], queen[1], 8, 8)) {
                rets.add(Arrays.asList(queen[0], queen[1]));
            }
        }
        return rets;
    }
   */

    final int KING = 2;
    final int QUEEN = 1;
    private int[] rows = {-1, 1, 0, 0, -1, 1,-1, 1};
    private int[] cols = { 0, 0,-1, 1, -1, 1, 1,-1};

    private boolean attack(int[][] chessBoard, int x, int y, int m, int n) {
        for (int i = 0; i < 8; i++) {
            int dx = rows[i];
            int dy = cols[i];
            int tx = x;
            int ty = y;
            do {
                tx += dx;
                ty += dy;
            }while ( tx >= 0 && ty >= 0 && tx < m && ty < n
                    && chessBoard[tx][ty] != QUEEN && chessBoard[tx][ty] != KING);
            if( tx >= 0 && ty >= 0 && tx < m && ty < n && chessBoard[tx][ty] == KING) return true;
        }
        return false;
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] chessBoard = new int[8][8];
        for (int[] queen : queens) {
            chessBoard[queen[0]][queen[1]] = QUEEN;
        }
        chessBoard[king[0]][king[1]] = KING;
        List<List<Integer>> rets = new ArrayList<>();
        for (int[] queen : queens) {
            if( attack(chessBoard, queen[0], queen[1], 8, 8))
                rets.add(Arrays.asList(queen[0], queen[1]));
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1222 lc = new LeetCode1222();
        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0, 0};
        List<List<Integer>> rets = lc.queensAttacktheKing(queens, king);
        System.out.println(rets);

    }

}
