package cn.karent.leetcode_v1.weeklycontest305;

import java.util.*;

/******************************************
 * 算术三元组的数目
 * @author wan
 * @date 2022.08.07 10:30
 ******************************************/
public class LeetCode6136 {

    public int arithmeticTriplets(int[] nums, int diff) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[k] - nums[j] == diff && nums[j] - nums[i] == diff) {
                        ret++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6136 lc = new LeetCode6136();
    }

}
