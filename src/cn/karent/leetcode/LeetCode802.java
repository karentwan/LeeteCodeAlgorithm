package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 找到最终的安全状态
 */
public class LeetCode802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> rets = new ArrayList<>();
        List<List<Integer>> edges = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                edges.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if( indegree[i] == 0) {
                st.push(i);
            }
        }
        while( !st.isEmpty() ) {
            int v = st.pop();
            rets.add(v);
            for (int i = 0; i < edges.get(v).size(); i++) {
                int w = edges.get(v).get(i);
                indegree[w]--;
                if( indegree[w] == 0) {
                    st.push(w);
                }
            }
        }
        Collections.sort(rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode802 lc = new LeetCode802();
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> rets = lc.eventualSafeNodes(graph);
        LeetCodeUtil.print(rets);
    }

}
