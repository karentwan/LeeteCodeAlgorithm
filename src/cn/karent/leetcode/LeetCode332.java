package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 重新安排行程
 */
public class LeetCode332 {

    private Map<String, Integer> map = new HashMap<>();

    private void dfs(List<PriorityQueue<String>> edges, String key, int idx, List<String> rets) {
        PriorityQueue<String> edge = edges.get(idx);
        while( !edge.isEmpty() ) {
            String k = edge.poll();
            int next = map.get(k);
            dfs(edges, k, next, rets);
        }
        rets.add(key);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> rets = new ArrayList<>();
        int n = 0;
        for(List<String> ticket : tickets) {
            if( !map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), n++);
            }
            if( ! map.containsKey(ticket.get(1))) {
                map.put(ticket.get(1), n++);
            }
        }
        if( n == 0) {
            return rets;
        }
        List<PriorityQueue<String>> edges = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            edges.add(new PriorityQueue<>());
        }
        for(List<String> ticket : tickets) {
            edges.get(map.get(ticket.get(0))).offer(ticket.get(1));
        }
        dfs(edges, "JFK", map.get("JFK"), rets);
        Collections.reverse(rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode332 lc = new LeetCode332();
        String[][] arr = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
        List<List<String>> tickets = LeetCodeUtil.arr2list(arr);
        List<String> rets = lc.findItinerary(tickets);
        LeetCodeUtil.print(rets);
    }
}
