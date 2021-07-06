package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.07.06
 ***********************************************/
public class LeetCode1418 {

    private List<String> int2str(int[] src) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < src.length; i++) {
            ret.add(src[i] + "");
        }
        return ret;
    }

    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> rets = new ArrayList<>();
        List<String> column = new ArrayList<>();
        Set<String> vis = new HashSet<>();
        for (int i = 0; i < orders.size(); i++) {
            List<String> item = orders.get(i);
            String product = item.get(2);
            if( !vis.contains(product)) {
                column.add(product);
                vis.add(product);
            }
        }
        Collections.sort(column);
        column.add(0, "Table");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 1; i < column.size(); i++) {
            map.put(column.get(i), i);
        }
        rets.add(column);
        List<int[]> tmps = new ArrayList<>();
        int n = column.size();
        int cnt = 0;
        Map<Integer, Integer> tableMap = new HashMap<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            // 初始化
            int[] tmp = null;
            if( tableMap.containsKey(table)) {
                tmp = tmps.get(tableMap.get(table));
            } else {
                tmp = new int[n];
                tmps.add(tmp);
                tmp[0] = table;
                tableMap.put(table, cnt++);
            }
            String product = order.get(2);
            tmp[map.get(product)]++;
        }
        Collections.sort(tmps, (k1, k2)->k1[0] - k2[0]);
        for (int i = 0; i < tmps.size(); i++) {
            rets.add(int2str(tmps.get(i)));
        }
        return rets;
    }

    public static void main(String[] args) {

    }

}
