package cn.karent.leetcode;

/**
 * 非递减数列
 */
public class LeetCode665 {

    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 0; i < nums.length && cnt <= 1; i++) {
            if(i > 0 && nums[i] < nums[i-1]) {
                cnt++;
                if( i == 1 && nums[i] >= nums[i-2]) {
                    nums[i-1] = nums[i];
                } else {
                    nums[i] = nums[i-1];
                }
            }
        }
        return cnt <= 1;
    }

}
