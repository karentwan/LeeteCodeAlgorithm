package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 数组的均值分割
 * @author wan
 * @date 2022.11.14 10:35
 ******************************************/
public class LeetCode805 {


    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, m = n / 2, sum = 0;
        sum = Arrays.stream(nums).sum();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s = 0; s < (1 << m); s++) {
            int tot = 0, cnt = 0;
            for (int i = 0; i < m; i++) {
                if (((s >> i) & 1) == 1) {
                    tot += nums[i];
                    cnt++;
                }
            }
            Set<Integer> set = map.getOrDefault(tot, new HashSet<>());
            set.add(cnt);
            map.put(tot, set);
        }
        for (int s = 0; s < (1 << (n - m)); s++) {
            int tot = 0, cnt = 0;
            for (int i = 0; i < (n - m); i++) {
                if (((s >> i) & 1) == 1) {
                    tot += nums[i+m]; cnt++;
                }
            }
            for (int k = Math.max(1, cnt); k < n; k++) {
                if (k * sum % n != 0) continue;
                int t = k * sum / n;
                if (!map.containsKey(t - tot)) continue;
                if (!map.get(t - tot).contains(k - cnt)) continue;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode805 lc = new LeetCode805();
        int[] arr = {18, 10, 5, 3};
        System.out.println(lc.splitArraySameAverage(arr));
    }

}
