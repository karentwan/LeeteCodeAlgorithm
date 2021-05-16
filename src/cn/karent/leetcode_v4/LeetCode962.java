package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最大宽度坡
 * 可以利用有序来去掉形成坡度, 然后只要比较索引即可
 * @author wan
 * @date 2021.05.16
 ********************************************/
public class LeetCode962 {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Integer[] indexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        // 先对索引排序, 问题就转变为, 索引i右边的最大值与第i个元素的差值
        Arrays.sort(indexes, (k1, k2) -> nums[k1] - nums[k2]);
        int m = n;
        int ret = 0;
        for (Integer idx : indexes) {
            ret = Math.max(ret, idx - m);
            m = Math.min(idx, m);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode962 lc = new LeetCode962();
        int[] arr = {6, 0, 8, 2, 1, 5};
        int ret = lc.maxWidthRamp(arr);
        System.out.println(ret);
    }

}
