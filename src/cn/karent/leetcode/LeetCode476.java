package cn.karent.leetcode;

/**
 * 数字的补数
 */
public class LeetCode476 {

    public int findComplement(int num) {
        int n = num;
        int mask = 0;
        int i = 0;
        while( n > 0) {
            mask |= (1 << i);
            n >>= 1;
            i++;
        }
        return (num ^ mask) & mask;
    }

    public static void main(String[] args) {
        LeetCode476 lc = new LeetCode476();
        int num = 1;
        int ret = lc.findComplement(num);
        System.out.println(ret);
    }

}
