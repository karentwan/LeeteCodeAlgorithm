package cn.karent.leetcode_v1.weeklycontest304;

import java.util.*;

/******************************************
 * 使数组中所有元素都等于零
 * @author wan
 * @date 2022.07.31 10:30
 ******************************************/
public class LeetCode6132 {

    public int minimumOperations(int[] nums) {
        int[] cache = new int[101];
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            cache[nums[i]]++;
            if (cache[nums[i]] == 1 && nums[i] > 0) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6132 lc = new LeetCode6132();
    }

}
