package cn.karent.leetcode_v4.weeklycontest240;

import java.util.*;

/********************************************
 * description: 有向图中最大颜色值
 * @author wan
 * @date 2021.05.10
 ********************************************/
public class Algo1857 {

    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> edgeLists = new ArrayList<>();
        int n = colors.length();
        for (int i = 0; i < n; i++) {
            edgeLists.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int s = edge[0];
            int e = edge[1];
            edgeLists.get(s).add(e);
            indegree[e]++;
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if( indegree[i] == 0) {
                st.push(i);
            }
        }
        // 表示以节点v为终点的所有路径中, 包含颜色c的节点数量的最大值
        int[][] dp = new int[n][26];
        int found = 0;
        while (!st.isEmpty()) {
            found++;
            int e = st.pop();
            // 求出它的前驱节点
            dp[e][colors.charAt(e) - 'a']++;
            List<Integer> edge = edgeLists.get(e);
            for (int i : edge) {
                indegree[i]--;
                if( indegree[i] == 0) {
                    st.push(i);
                }
                for (int j = 0; j < 26; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[e][j]);
                }
            }
        }
        if( found != n) return -1;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                ret = Math.max(ret, dp[i][j]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo1857 lc = new Algo1857();
        String colors = "abaca";
        int[][] edges = {{0,1},{0,2},{2,3},{3,4}};
        int ret = lc.largestPathValue(colors, edges);
        System.out.println(ret);
    }

}
