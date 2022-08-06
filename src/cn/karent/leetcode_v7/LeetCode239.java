package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 滑动窗口的最大值
 * @author wan
 * @date 2022.08.06 10:46
 ******************************************/
public class LeetCode239 {
//
//    private void add(TreeMap<Integer, Integer> map, int key) {
//        map.put(key, map.getOrDefault(key, 0) + 1);
//    }
//
//    public void remove(TreeMap<Integer, Integer> map, int key) {
//        if(map.get(key) == 1) map.remove(key);
//        else map.put(key, map.get(key)-1);
//    }
//
//    // TreeMap 一把梭
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        int[] rets = new int[nums.length-k+1];
//        for (int i = 0; i < k-1; i++) {
//            add(treeMap, nums[i]);
//        }
//        for (int i = k-1, j = 0; i < nums.length; i++, j++) {
//            add(treeMap, nums[i]);
//            Integer ret = treeMap.lastKey();
//            rets[j] = ret;
//            remove(treeMap, nums[j]);
//        }
//        return rets;
//    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调递减栈
        LinkedList<Integer> st = new LinkedList<>();
        int[] rets = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 注意: st.peek() 等于 st.peekFirst()
            while (!st.isEmpty() && nums[i] >= nums[st.peekLast()]) {
                st.pollLast();
            }
            st.offerLast(i);
            if (i >= k - 1) {
                Integer idx = st.peekFirst();
                rets[i-k+1] = nums[idx];
                if (idx == i - k + 1) st.pollFirst();
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode239 lc = new LeetCode239();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] rets = lc.maxSlidingWindow(nums, k);
        LeetCodeUtil.print(rets);
    }

}
