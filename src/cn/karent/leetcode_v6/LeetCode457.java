package cn.karent.leetcode_v6;

public class LeetCode457 {

    public boolean circularArrayLoop1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if( nums[i] == 0) continue;
            int slow = i, fast = next(nums, i);
            while ( nums[slow] * nums[fast] > 0
                    && nums[slow] * nums[next(nums, fast)] > 0) {
                if( slow == fast) {
                    if( slow != next(nums, fast))
                        return true;
                    else break;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            for (int j = i; nums[j] * nums[next(nums, j)] > 0; ) {
                int t = next(nums, j);
                nums[j] = 0;
                j = t;
            }
        }
        return false;
    }

    private int next(int[] nums, int idx) {
        int n = nums.length;
        return ((idx + nums[idx]) % n + n) % n;
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if( nums[i] == 0) continue;
            int slow = i, fast = next(nums, i);
            while ( nums[slow] * nums[fast] > 0 ) {
                if( slow == fast) {
                    if( slow != next(nums, fast))
                        return true;
                    else break;
                }
                slow = next(nums, slow);
                fast = next(nums, next(nums, fast));
            }
            for (int j = i; nums[j] * nums[next(nums, j)] > 0; ) {
                int t = next(nums, j);
                nums[j] = 0;
                j = t;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode457 lc = new LeetCode457();
//        int[] arr = {2,-1,1,2,2};
//        int[] arr = {-1, 2};
        int[] arr = {-2,1,-1,-2,-2};
//        int[] arr = {-2,-3,-9};
        boolean ret = lc.circularArrayLoop1(arr);
        System.out.println(ret);
    }


}
