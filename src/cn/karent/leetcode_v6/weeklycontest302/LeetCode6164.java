package cn.karent.leetcode_v6.weeklycontest302;

import java.util.*;

/******************************************
 * 数位和相等数对的最大和
 * @author wan
 * @date 2022.07.17 10:35
 ******************************************/
public class LeetCode6164 {

    public int maximumSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int v = sum(num);
            if (map.get(v) == null) map.put(v, new ArrayList<>());
            map.get(v).add(num);
        }
        int ret = -1;
        for (Map.Entry<Integer, List<Integer>> kv : map.entrySet()) {
            List<Integer> list = kv.getValue();
            Collections.sort(list);
            if (list.size() >= 2) {
                ret = Math.max(ret, list.get(list.size()-1) + list.get(list.size()-2));
            }
        }
        return ret;
    }

    private int sum(int num) {
        int ret = 0;
        while (num > 0) {
            ret += num % 10;
            num /= 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6164 lc = new LeetCode6164();
        int[] nums = {18, 43, 36, 13, 7};
        System.out.println(lc.maximumSum(nums));
    }

}
