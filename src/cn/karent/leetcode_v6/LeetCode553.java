package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-02-27 09:27
 * @description: 最优除法
 *******************************************/
public class LeetCode553 {
/*
    // 数学解法, 最大值一定是nums0 / (nums1/nums2/nums3...)这种, 分母越小越好
    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length-1; i++) {
            sb.append(nums[i]).append("/");
        }
        sb.append(nums[nums.length - 1]).append(")");
        return sb.toString();
    }
   */

    class Node {
        double minVal = 1000., maxVal = 0.;
        String minStr = null, maxStr = null;
    }

    // 区间DP解法
    public String optimalDivision(int[] nums) {
        int size = nums.length;
        Node[][] dp = new Node[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = new Node();
            }
        }
        for (int i = 0; i < size; i++) {
            dp[i][i].minVal = nums[i];
            dp[i][i].maxVal = nums[i];
            dp[i][i].minStr = String.valueOf(nums[i]);
            dp[i][i].maxStr = String.valueOf(nums[i]);
        }
        for (int i = size-1; i >= 0; i--) {
            for (int j = i+1; j < size; j++) {
                for (int k = i; k < j; k++) {
                    // 求最小值
                    if ( dp[i][k].minVal / dp[k+1][j].maxVal < dp[i][j].minVal ) {
                        dp[i][j].minVal = dp[i][k].minVal / dp[k+1][j].maxVal;
                        if (k+1 == j) {
                            dp[i][j].minStr = dp[i][k].minStr + "/" + dp[k + 1][j].maxStr;
                        } else {
                            dp[i][j].minStr = dp[i][k].minStr + "/(" + dp[k + 1][j].maxStr + ")";
                        }
                    }
                    // 最大
                    if ( dp[i][k].maxVal / dp[k+1][j].minVal > dp[i][j].maxVal) {
                        dp[i][j].maxVal = dp[i][k].maxVal / dp[k+1][j].minVal;
                        if (k+1 == j) {
                            dp[i][j].maxStr = dp[i][k].maxStr + "/" + dp[k + 1][j].minStr;
                        } else {
                            dp[i][j].maxStr = dp[i][k].maxStr + "/(" + dp[k + 1][j].minStr + ")";
                        }
                    }
                }
            }
        }
        return dp[0][size-1].maxStr;
    }

    public static void main(String[] args) {
        LeetCode553 lc = new LeetCode553();
        int[] nums = {1000, 100, 10, 2};
        System.out.println(lc.optimalDivision(nums));
    }

}
