package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 可能的二分法
 * @author wan
 * @date 2022.10.16 09:36
 ******************************************/
public class LeetCode886 {

    private boolean dfs(List<Integer>[] edges, int[] color, int newColor, int idx) {
        color[idx] = newColor;
        List<Integer> edge = edges[idx];
        for (int i : edge) {
            if (color[i] != 0 && color[i] == color[idx]) {
                return false;
            }
            if (color[i] == 0 && !dfs(edges, color, 3 ^ newColor, i)) {
                return false;
            }
        }
        return true;
    }

    // 染色法
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] edges = new List[n+1];
        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            int s = dislike[0], e = dislike[1];
            edges[s].add(e);
            edges[e].add(s);
        }
        int[] color = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0 && !dfs(edges, color,1, i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode886 lc = new LeetCode886();
        int n = 4;
        int[][] dislike = {{1,2},{1,3},{2,4}};
        System.out.println(lc.possibleBipartition(n, dislike));
    }

}
