package cn.karent.leetcode_v2;

/**
 * 位1的个数
 */
public class LeetCode191 {

    public int hammingWeight(int n) {
        int cnt = 0;
        while( n != 0) {
            cnt += (n & 1);
            n >>>= 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode191 lc = new LeetCode191();
        int n = 2;
        int ret = lc.hammingWeight(n);
        System.out.println(ret);
    }

}
