package cn.karent.leetcode_v8;

import java.util.*;

/**
 * 水域大小
 *
 * @author wan
 * @date 2023.06.22 11:13
 */
public class Offer1619 {

    private int dfs(int[][] land, int si, int sj, int m, int n) {
        if (si < 0 || si >= m || sj < 0 || sj >= n || land[si][sj] == -1 || land[si][sj] > 0) {
            return 0;
        }
        int cnt = 1;
        land[si][sj] = -1;
        int[][] dirs = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };
        for (int[] dir : dirs) {
            int newSi = si + dir[0], newSj = sj + dir[1];
            cnt += dfs(land, newSi, newSj, m, n);
        }
        return cnt;
    }

    public int[] pondSizes(int[][] land) {
        int m = land.length;
        if (m == 0) {
            return new int[0];
        }
        int n = land[0].length;
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = dfs(land, i, j, m, n);
                if (t > 0) {
                    tmp.add(t);
                }
            }
        }
        Collections.sort(tmp);
        int[] rets = new int[tmp.size()];
        for (int i = 0; i < tmp.size(); i++) {
            rets[i] = tmp.get(i);
        }
        return rets;
    }


    public static void main(String[] args) {
        Offer1619 lc = new Offer1619();
        int[][] input = {
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        };
        int[] rets = lc.pondSizes(input);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
