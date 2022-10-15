package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 避免洪水泛滥
 * @author wan
 * @date 2022.10.15 22:49
 ******************************************/
public class LeetCode1488 {

    public int[] avoidFlood(int[] rains) {
        int size = rains.length;
        int[] rets = new int[size];
        TreeSet<Integer> tree = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (rains[i] == 0) {
                tree.add(i);
            } else {
                // 如果有水则需要抽干
                if (map.containsKey(rains[i])) {
                    if (tree.isEmpty()) return new int[0];
                    Integer idx = map.get(rains[i]);
                    Integer t = tree.higher(idx);
                    if (t == null) return new int[0];
                    rets[t] = rains[i];
                    tree.remove(t);
                }
                map.put(rains[i], i);
                rets[i] = -1;
            }
        }
        Iterator<Integer> iter = tree.iterator();
        while (iter.hasNext()) {
            rets[iter.next()] = 1;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1488 lc = new LeetCode1488();
//        int[] rains = {1,2,3,4};
//        int[] rains = {1,2,0,0,2,1};
        int[] rains = {69,0,0,0,69};
//        int[] rains = {0,1,1};
        int[] rets = lc.avoidFlood(rains);
        LeetCodeUtil.print(rets);
    }

}
