package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 两束之和
 * @author wan
 * @date 2021.07.04
 ***********************************************/
public class LeetCode1 {

    public int[] twoSum1(int[] nums, int target) {
        Integer[][] arr = new Integer[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (k1 ,k2)->k1[0] - k2[0]);
        for (int i = 0, j = nums.length-1; i < j; ) {
            int t = 0;
            if(( t = arr[i][0] + arr[j][0] )< target) {
                i++;
            } else if( t > target) j--;
            else return new int[]{arr[i][1], arr[j][1]};
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if( map.containsKey(t)) {
                return new int[]{map.get(t), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {

    }

}
