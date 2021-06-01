package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 找出井字棋的获胜者
 * @author wan
 * @date 2021.06.01
 ********************************************/
public class LeetCode1275 {

    private int[][] stateTable = {{0,1,3}, {1,2,1}, {3,1,0}};  // 一共三种状态

    private boolean winHorizontal(int[][] moves, int x, int target) {
        for (int i = 0; i < 3; i++) {
            if( moves[x][i] != target) return false;
        }
        return true;
    }

    private boolean winVertical(int[][] moves, int y, int target) {
        for (int i = 0; i < 3; i++) {
            if( moves[i][y] != target) return false;
        }
        return true;
    }

    private boolean winRight(int[][] moves, int target) {
        for (int i = 0; i < 3; i++) {
            if( moves[i][i] != target) return false;
        }
        return true;
    }

    private boolean winLeft(int[][] moves, int target) {
        for (int i = 0; i < 3; i++) {
            if( moves[i][2-i] != target) return false;
        }
        return true;
    }

    private boolean win(int[][] moves, int x, int y, int target) {
        moves[x][y] = target;
        int state = stateTable[x][y];
        boolean ret = winHorizontal(moves, x, target) || winVertical(moves, y, target);
        switch (state) {
            case 0:
                ret = ret || winRight(moves, target);
                break;
            case 1:
                break;
            case 2:
                ret = ret || winRight(moves, target) || winLeft(moves, target);
                break;
            case 3:
                ret = ret || winLeft(moves, target);
                break;
        }
        return ret;
    }

    public String tictactoe(int[][] moves) {
        int t = 0;
        int[][] chess = new int[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(chess[i], -1);
        }
        for (int[] move : moves) {
            if( win(chess, move[0], move[1], t)) {
                return t == 0 ? "A" : "B";
            }
            t = (t + 1) % 2;
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static void main(String[] args) {
        LeetCode1275 lc = new LeetCode1275();
        int[][] moves= {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};
        String ret = lc.tictactoe(moves);
        System.out.println(ret);
    }

}
