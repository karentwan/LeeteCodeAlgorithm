package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 大餐计数
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1711 {

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : deliciousness) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        long ret = 0;
        int mod = ((int) (1e9 + 7));
        Arrays.sort(deliciousness);
        for (int i = 0; i < deliciousness.length; i++) {
            int dish = deliciousness[i];
            for (int j = 0; j <= 30; j++) {
                int s = 1 << j;
                if( s < dish) continue;
                int a = s - dish;
                if( map.containsKey(a) ) {
                    if( a > dish) {
                        ret = ret + map.get(a);
                    } else if( a == dish && (i == 0 || deliciousness[i] != deliciousness[i-1])) {
                        long v = map.get(dish);
                        ret = ret + v * (v - 1) / 2;
                    }
                    ret = ret % mod;
                }
            }
        }
        return ((int) (ret));
    }

    public static void main(String[] args) {
        LeetCode1711 lc = new LeetCode1711();
        int[] arr = {1, 3, 5, 7, 9};
//        int[] arr = {1,1,1,3,3,3,7};
        int ret = lc.countPairs(arr);
        System.out.println(ret);
    }

}
