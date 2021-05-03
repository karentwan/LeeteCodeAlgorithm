package cn.karent.leetcode;

/**
 * 汉明距离
 * 统计数组中每一位的0和1个数
 */
public class LeetCode477 {

    public int totalHammingDistance(int[] nums) {
        int[] cnts = new int[32];
        for(int num : nums) {
            int i = 0;
            while( num > 0) {
                cnts[i] += (num & 1);
                i++;
                num >>= 1;
            }
        }
        int n = nums.length;
        int ret = 0;
        for(int i = 0; i < 32; i++) {
            ret += (cnts[i] * (n - cnts[i]));
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode477 lc = new LeetCode477();
        int[] nums = {4,14,2};
        int ret = lc.totalHammingDistance(nums);
        System.out.println(ret);
    }

}
