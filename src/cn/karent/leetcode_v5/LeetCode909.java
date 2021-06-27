package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 蛇梯棋
 * @author wan
 * @date 2021.06.27
 ***********************************************/
public class LeetCode909 {

    private int[] pos2xy(int pos, int n) {
        pos--;
        int r = n - pos / (n + 1);
        int t = pos % (n + 1);
        int c = (n - r) % 2 == 0 ? t : n - t;
        return new int[]{r, c};
    }

    private void next(int[][] board, int pos, Queue<Integer> que,
                      Set<Integer> vis) {
        int n = board.length;
        for (int i = 1; i <= 6; i++) {
            int nt = pos + i;
            int[] p = pos2xy(nt, n-1);
            if( p[0] < 0 || p[1] < 0) continue;
            if( board[p[0]][p[1]] != -1) {
                nt = board[p[0]][p[1]];
            }
            if( !vis.contains(nt)) {
                que.offer(nt);
                vis.add(nt);
            }
        }
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        que.offer(1);
        vis.add(1);
        int n = board.length;
        int ret = 0;
        int target = n * n;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int item = que.poll();
                if( item == target) return ret;
                next(board, item, que, vis);
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode909 lc = new LeetCode909();
        int[][] arr = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int ret = lc.snakesAndLadders(arr);
        System.out.println(ret);

    }

}
