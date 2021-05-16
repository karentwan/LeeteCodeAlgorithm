package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 二倍数对数目, 类似于判断数组中满足条件相等的
 * 题目都可以用桶的思想来做, 将满足一定条件的元素全部放在一个桶
 * 里面, 然后桶内判断即可
 * @author wan
 * @date 2021.05.15
 ********************************************/
public class LeetCode954 {

    private void add(Map<Integer, Integer> map, int k) {
        map.put(k, map.getOrDefault(k, 0)+1);
    }

    private void remove(Map<Integer, Integer> map, int k) {
        if( map.containsKey(k) ) {
            if( map.get(k) == 1) map.remove(k);
            else map.put(k, map.get(k)-1);
        }
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        // 拍完续不容易出错
        Arrays.sort(arr);
        for (int item : arr) {
            if( map.containsKey(item * 2) ) {
                remove(map, item*2);
            } else if( item % 2 == 0 && map.containsKey(item / 2)) {
                remove(map, item/2);
            } else add(map, item);
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        LeetCode954 lc = new LeetCode954();
//        int[] arr = {3, 1, 3, 6};
//        int[] arr = {2,1,2,6};
//        int[] arr = {4,-2,2,-4};
        int[] arr = {-1,4,6,8,-4,6,-6,3,-2,3,-3,-8};
        System.out.println(lc.canReorderDoubled(arr));
    }

}
