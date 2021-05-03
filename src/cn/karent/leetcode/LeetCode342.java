package cn.karent.leetcode;

/**
 * 4的幂
 */
public class LeetCode342 {
    public boolean isPowerOfFour(int n) {
        return (n > 0) && ( (n & (n-1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
