package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 从相邻元素对还原数组
 * @author wan
 * @date 2021.07.25
 ***********************************************/
public class LeetCode1743 {

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void dfs(List<List<Node>> edges, int idx, boolean[] visited, List<Integer> ret) {
        List<Node> edge = edges.get(idx);
        for (Node e : edge) {
            if( !visited[e.value]) {
                visited[e.value] = true;
                ret.add(e.key);
                dfs(edges, e.value, visited, ret);
            }
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        List<List<Node>> edges = new ArrayList<>();
        for (int i = 0; i < n+2; i++) {
            edges.add(new ArrayList<>());
        }
        Map<Integer, Node> map = new HashMap<>();
        int cnt = 0;
        List<Node> tmp = new ArrayList<>();
        for (int[] pair : adjacentPairs) {
            if( !map.containsKey(pair[0])) {
                Node node = new Node(pair[0], cnt++);
                map.put(pair[0], node);
                tmp.add(node);
            }
            if( !map.containsKey(pair[1])) {
                Node node = new Node(pair[1], cnt++);
                map.put(pair[1], node);
                tmp.add(node);
            }
        }
        int[] indegree = new int[n+2];
        for (int[] pair : adjacentPairs) {
            Node s = map.get(pair[0]);
            Node e = map.get(pair[1]);
            edges.get(s.value).add(e);
            edges.get(e.value).add(s);
            indegree[s.value]++;
            indegree[e.value]++;
        }
        int start = 0;
        for (int i = 0; i < n + 2; i++) {
            if( indegree[i] == 1) start = i;
        }
        List<Integer> list = new ArrayList<>();
        list.add(tmp.get(start).key);
        boolean[] visited = new boolean[n+2];
        visited[start] = true;
        dfs(edges, start, visited, list);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1743 lc = new LeetCode1743();
        int[][] adj = {{2,1},{3,4},{3,2}};
        int[] ret = lc.restoreArray(adj);
        for (int i : ret) {
            System.out.println(i + " ");
        }
    }

}
