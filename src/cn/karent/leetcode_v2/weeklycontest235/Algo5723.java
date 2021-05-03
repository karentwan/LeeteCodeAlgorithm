package cn.karent.leetcode_v2.weeklycontest235;

import java.util.*;

import cn.karent.util.*;


/**
 * 查找用户活跃分钟数
 * @author wan
 * @date 2021.04.04
 */
public class Algo5723 {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] rets = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.computeIfAbsent(log[0], (key) -> new HashSet<Integer>()).add(log[1]);
        }
        for (Integer key : map.keySet()) {
            int v = map.get(key).size();
            rets[v-1]++;
        }
        return rets;
    }

    public static void main(String[] args) {
        Algo5723 algo = new Algo5723();
        int[][] logs = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k = 5;
        int[] rets = algo.findingUsersActiveMinutes(logs, k);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
