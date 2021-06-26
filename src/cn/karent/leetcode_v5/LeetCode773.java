package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 滑动谜题
 * @author wan
 * @date 2021.06.26
 ***********************************************/
public class LeetCode773 {

    private void swap(char[] chs, int x1, int x2) {
        char c = chs[x1];
        chs[x1] = chs[x2];
        chs[x2] = c;
    }

    private void next(Queue<String> que, Set<String> vis, String s) {
        int[][] neibor = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        char[] chs = s.toCharArray();
        int idx = 0;
        while (idx < chs.length && chs[idx] != '0')
            idx++;
        for (int item : neibor[idx]) {
            swap(chs, item, idx);
            String t = new String(chs);
            if( !vis.contains(t)) {
                que.offer(t);
                vis.add(t);
            }
            swap(chs, item, idx);
        }
    }

    public int slidingPuzzle(int[][] board) {
        Queue<String> que = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        String target = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        que.offer(initial);
        vis.add(initial);
        int ret = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String s = que.poll();
                if( s.equals(target)) return ret;
                next(que, vis, s);
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode773 lc = new LeetCode773();
        int[][] board = {{1,2,3},{4,0,5}};
        int ret = lc.slidingPuzzle(board);
        System.out.println(ret);
    }

}
