package cn.karent.leetcode_v2;

/**
 * 子数组和排序后的区间和
 */
public class LeetCode1508 {

    private long getKth(long[] sum, int n, int k) {
        long left = 0, right = ((long) 1e5);
        while (left < right) {
            long mid = left + ( right - left) / 2;
            if( getCnt(sum, n, mid) >= k) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    // 严格上小于num的数量
    private long getCnt(long[] sum, int n, long num) {
        long ret = 0;
        for (int i = 0, p = 1; i < n; i++) {
            while (p <= n && sum[p] - sum[i] <= num) {
                p++;
            }
            ret += p - i - 1;
        }
        return ret;
    }

    private long F(long[] sum, long[] preSum, int n, int k) {
        long num = getKth(sum, n, k);
        long ret = 0;
        long cnt = 0;
        for (int i = 0, p = 1; i < n; i++) {
            while ( p <= n && sum[p] - sum[i] < num) {
                p++;
            }
            ret += preSum[p-1] - preSum[i] - ( p - i - 1) * sum[i];
            cnt += p - i - 1;
        }
        ret = ret + ( k - cnt) * num;
        return ret;
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        long[] sum = new long[n+1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
        long[] preSum = new long[n+1];
        preSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + sum[i];
        }
        return ((int) ((F(sum, preSum, n, right) - F(sum, preSum, n, left - 1)) % (1e9 + 7)));
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 3;
        int right = 4;
        LeetCode1508 lc = new LeetCode1508();
        int ret = lc.rangeSum(nums, n, left, right);
        System.out.println(ret);
    }


}
