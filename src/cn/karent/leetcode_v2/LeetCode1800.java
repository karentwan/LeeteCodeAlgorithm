package cn.karent.leetcode_v2;

/**
 * 最大升序子数组和
 */
public class LeetCode1800 {

    public int maxAscendingSum(int[] nums) {
        int i = 0;
        int ret = 0;
        while (i < nums.length) {
            int wnd = nums[i++];
            ret = Math.max(wnd, ret);
            while ( i < nums.length && nums[i] > nums[i-1]) {
                wnd += nums[i++];
                ret = Math.max(ret, wnd);
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        LeetCode1800 lc = new LeetCode1800();
//        int[] nums = {10,20,30,5,10,50};
        int[] nums = {10,20,30,40,50};
        int ret = lc.maxAscendingSum(nums);
        System.out.println(ret);
    }

}
