package cn.karent.leetcode;

/**
 * 最长连续递增序列
 */
public class LeetCode674 {

    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int ret = 1;
        int wnd = 1;
        for(int j = 1; j < nums.length; j++) {
            if( nums[j] > nums[j-1]) {
                wnd++;
            } else {
                wnd = 1;
            }
            ret = Math.max(ret, wnd);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode674 lc = new LeetCode674();
        int[] nums = {1,3,5,4,7};
        int ret = lc.findLengthOfLCIS(nums);
        System.out.println(ret);
    }

}
