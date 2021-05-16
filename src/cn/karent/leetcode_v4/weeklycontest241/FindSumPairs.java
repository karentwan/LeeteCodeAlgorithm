package cn.karent.leetcode_v4.weeklycontest241;

import java.util.*;

/********************************************
 * description: 找出和为指定值的下标对
 * @author wan
 * @date 2021.05.16
 ********************************************/
public class FindSumPairs {

    class TreeArray {

        private int[] data;
        private int n;

        public TreeArray(int[] data) {
            int n = data.length + 1;
            this.data = new int[n+1];
            for (int i = 1; i < n; i++) {
                update(i, data[i-1]);
            }
        }

        private int lowbit(int x) {
            return x & -x;
        }

        public void update(int idx, int val) {
            for (int i = idx; i < n; i += lowbit(i)) {
                data[i] += val;
            }
        }

        public int get(int idx) {
            int ret = 0;
            for (int i = idx; i > 0; i -= lowbit(i)) {
                ret += data[idx];
            }
            return ret;
        }

    }

    private int[] nums1;

    private int[] nums2;

    private Map<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        map = new HashMap<>();
        for (int item : nums2) {
            add(item);
        }
    }

    private void add(int key) {
        map.put(key, map.getOrDefault(key, 0)+1);
    }

    private void subtract(int key) {
        if( map.containsKey(key)) {
            if( map.get(key) == 1) map.remove(key);
            else map.put(key, map.get(key)-1);
        }
    }

    public void add(int index, int val) {
        if( index >= nums2.length) return;
        int key = this.nums2[index];
        subtract(key);
        this.nums2[index] += val;
        add(nums2[index]);
    }

    public int count(int tot) {
        int ret = 0;
        for (int i = 0; i < nums1.length; i++) {
            int key = tot - nums1[i];
            if( map.containsKey(key)) {
                ret += map.get(key);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        FindSumPairs lc = new FindSumPairs();

    }

}
