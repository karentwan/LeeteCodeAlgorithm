package cn.karent.leetcode_v7;

/*******************************************
 * @author wan
 * @date: 2022-04-30 10:37
 * @description: 最小差值 二
 *******************************************/
public class LeetCode908 {

    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return Math.max(max - min - 2 * k, 0);
    }

    public static void main(String[] args) {
        LeetCode908 lc = new LeetCode908();
//        int[] nums = {1};
//        int k = 0;
        int[] nums = {1,3,6};
        int k = 3;
        System.out.println(lc.smallestRangeI(nums, k));
    }

}
