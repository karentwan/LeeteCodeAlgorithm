package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 公交路线
 * @author wan
 * @date 2021.06.28
 ***********************************************/
public class LeetCode815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = routes.length;
        Queue<Integer> que = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        if( source == target) return 0;
        for (int i = 0; i < n; i++) {
            for (int item : routes[i]) {
                map.computeIfAbsent(item, k -> new ArrayList<>()).add(i);
                if( item == source) que.offer(i);
            }
        }
        int ret = 1;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int s = que.poll();
                int[] plates = routes[s];
                for (int plate : plates) {
                    if( plate == target) return ret;
                    List<Integer> list = map.get(plate);
                    for (Integer bus : list) {
                        if( !vis.contains(bus)) {
                            vis.add(bus);
                            que.offer(bus);
                        }
                    }
                }
            }
            ret++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode815 lc = new LeetCode815();
        int[][] routes = {{1,2,7},{3,6,7}};
        int source = 1;
        int target = 6;
        int ret = lc.numBusesToDestination(routes, source, target);
        System.out.println(ret);
    }

}
