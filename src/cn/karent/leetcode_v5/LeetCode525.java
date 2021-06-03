package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 连续数组
 * @author wan
 * @date 2021.06.03
 ********************************************/
public class LeetCode525 {

    public int findMaxLength(int[] nums) {
        int ret = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int t1 = 2 * sum - i - 1;
            if( map.containsKey(t1)) {
                ret = Math.max(ret, i - map.get(t1));
            } else map.put(t1, i);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode525 lc = new LeetCode525();
//        int[] arr = {0, 1};
//        int[] arr = {0, 1, 0};
        int[] arr = {0, 1, 0, 0,1,0,0,1,1,1,0};
        int ret = lc.findMaxLength(arr);
        System.out.println(ret);
    }

}
