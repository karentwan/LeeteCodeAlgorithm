package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 蛇梯棋
 */
public class LeetCode909 {

    private int row;
    private int col;

    private int getRow(int n) {
        n--;
        int r = row - n / col - 1;
        return r;
    }

    private int getCol(int n, int r) {
        n--;
        int c = n % col;
        if( (row - r) % 2 == 0) {
            c = col - c - 1;
        }
        return c;
    }

    public int snakesAndLadders(int[][] board) {
        row = board.length;
        if( row == 0) {
            return 0;
        }
        col = board[0].length;
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        int ret = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        while( !que.isEmpty() ) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int node = que.poll();
                if( node == row * col) {
                    return ret;
                }
                int r = getRow(node);
                int c = getCol(node, r);
                for (int j = 1; j <= 6 ; j++) {
                    int newNode = node+j;
                    if( newNode > row * col) {
                        continue;
                    }
                    int nr = getRow(newNode);
                    int nc = getCol(newNode, nr);
                    if( board[nr][nc] != -1) {
                        newNode = board[nr][nc];
                    }
                    if( newNode > row * col) {
                        continue;
                    }
                    if( !visited.contains(newNode) ) {
                        que.offer(newNode);
                        visited.add(newNode);
                    }
                }
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode909 lc = new LeetCode909();
        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
//        int[][] board = {{1,1,-1},{1,1,1},{-1,1,1}};
//        int[][] board = {{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}};
//        int[][] board = {{-1,-1,16,6,-1},{-1,9,25,8,-1},{8,20,2,7,-1},{-1,-1,12,-1,-1},{-1,-1,-1,12,23}};
        int ret = lc.snakesAndLadders(board);
        System.out.println(ret);

    }

}
