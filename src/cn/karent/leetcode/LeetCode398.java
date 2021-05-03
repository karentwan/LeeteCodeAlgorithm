package cn.karent.leetcode;

/**
 * 蓄水池抽样
 */
public class LeetCode398 {

    private int[] nums = null;

    public LeetCode398(int[] nums) {
        this.nums = nums;
    }

    private int nextInt(int n) {
        int r = (int)(Math.random() * n);
        return r;
    }

    public int pick(int target) {
        int cnt = 0;
        int idx = -1;
        for(int i = 0; i < nums.length; i++) {
            if( target == nums[i]) {
                cnt++;
                if( nextInt(cnt) % cnt == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}
