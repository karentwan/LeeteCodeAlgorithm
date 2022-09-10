package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 计算右侧小于当前元素的个数
 * @author wan
 * @date 2022.09.10 12:28
 ******************************************/
public class LeetCode315 {

    private Integer[] rets;

    private void count(int[] nums, int l, int r, int[] indices) {
        int m = l + (r - l)/2;
        int i = l, j = m+1;
        while (i <= m) {
            while (j <= r && nums[indices[j]] < nums[indices[i]]) j++;
            rets[indices[i]] += j - m - 1;
            i++;
        }
    }

    private void mergeSort(int[] nums, int l, int r, int[] tmps, int[] indices) {
        if (l >= r) return;
        int m = l + (r - l) /2;
        mergeSort(nums, l, m, tmps, indices);
        mergeSort(nums, m+1, r, tmps, indices);
        count(nums, l, r, indices);  // 统计
        int i = l, j = m+1, k = l;
        while (i <= m && j <= r) {
            if (nums[indices[i]] <= nums[indices[j]]) {
                tmps[k] = indices[i++];
            } else {
                tmps[k] = indices[j++];
            }
            k++;
        }
        while (i <= m) {
            tmps[k++] = indices[i++];
        }
        while (j <= r) {
            tmps[k++] = indices[j++];
        }
        for (i = l; i <= r; i++) {
            indices[i] = tmps[i];
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        rets = new Integer[nums.length];
        Arrays.fill(rets, 0);
        int[] indices = new int[nums.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        mergeSort(nums, 0, nums.length-1, new int[nums.length], indices);
        return new ArrayList<>(Arrays.asList(rets));
    }

    public static void main(String[] args) {
        LeetCode315 lc = new LeetCode315();
//        int[] nums = {5,2,6,1};
        int[] nums = {2,0,1};
        List<Integer> rets = lc.countSmaller(nums);
        LeetCodeUtil.print(rets);
    }

}
