package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 下一个更大的元素 一
 * @author wan
 * @date 2022.08.26 12:33
 ******************************************/
public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> que = new ArrayDeque<>();
        int[] larger = new int[nums2.length];
        Arrays.fill(larger, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!que.isEmpty() && nums2[i] > nums2[que.peekLast()]) {
                larger[que.pollLast()] = i;
            }
            que.offerLast(i);
            map.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            int idx = larger[map.get(nums1[i])];
            nums1[i] = idx >= 0 ? nums2[idx] : -1;
        }
        return nums1;
    }

    public static void main(String[] args) {
        LeetCode496 lc = new LeetCode496();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        int[] rets = lc.nextGreaterElement(nums1, nums2);
        LeetCodeUtil.print(rets);
    }

}
