package cn.karent.leetcode;

/**
 * 寻找数组的中心索引
 */
public class LeetCode724 {

    public int pivotIndex(int[] nums) {
        if( nums.length < 3) {
            return -1;
        }
        int ret = -1;
        int[] preSum = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }
        int r = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            if( r == preSum[i]) {
                ret = i;
            }
            r += nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode724 lc = new LeetCode724();
        int[] nums = {1,2,3};
//        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {-1,-1,0,1,1,0};
        int ret = lc.pivotIndex(nums);
        System.out.println(ret);
    }

}
