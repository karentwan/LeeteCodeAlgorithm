package cn.karent.leetcode;

/**
 * 最大连续1的个数
 */
public class LeetCode485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int ret = 0;
        int wnd = 0;
        for(int i = 0; i < nums.length; i++) {
            if( nums[i] == 1) {
                wnd++;
            } else {
                wnd = 0;
            }
            ret = Math.max(ret, wnd);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode485 lc = new LeetCode485();
        int[] nums = {1,1,0,1,1,1};
        int ret = lc.findMaxConsecutiveOnes(nums);
        System.out.println(ret);
    }

}
