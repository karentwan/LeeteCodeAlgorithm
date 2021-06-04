package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 避免洪水泛滥
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class LeetCode1488 {

    private int binarySearch(List<Integer> zeros, int t) {  // 大于
        int l = 0, r = zeros.size();
        while ( l < r) {
            int m = l + (r - l)/2;
            if( zeros.get(m) > t) r = m;
            else l = m+1;
        }
        return l == zeros.size() ? -1 : zeros.get(l);
    }

    public int[] avoidFlood(int[] rains) {
        int[] rets = new int[rains.length];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> zeros = new ArrayList<>();
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if( rain == 0) {
                zeros.add(i);
                rets[i] = 1;
            } else {
                if( map.containsKey(rain)) {
                    int idx = binarySearch(zeros, map.get(rain));
                    if( idx > -1) {
                        rets[idx] = rain;
                        zeros.remove(((Integer) idx));
                    } else return new int[0];
                }
                map.put(rain, i);
                rets[i] = -1;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1488 lc = new LeetCode1488();
//        int[] rains = {1,2,3,4};
//        int[] rains = {1,2,0,0,2,1};
//        int[] rains = {0,1,1};
        int[] rains = {69,0,0,0,69};
        int[] rets = lc.avoidFlood(rains);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
