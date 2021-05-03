package cn.karent.leetcode;

/**
 * 子数组最大平均数
 */
public class LeetCode643 {

    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0;
        int wnd = 0, ret = 0;
        while( right < nums.length && right < k) {
            wnd += nums[right];
            right++;
        }
        ret = wnd;
        while( right < nums.length) {
            wnd += nums[right++];
            wnd -= nums[left++];
            ret = Math.max(ret, wnd);
        }
        return ret * 1.0 / k;
    }

    public static void main(String[] args) {
        LeetCode643 lc = new LeetCode643();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        double ret = lc.findMaxAverage(nums, k);
        System.out.println(ret);
    }
}
