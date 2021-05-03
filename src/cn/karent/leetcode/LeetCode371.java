package cn.karent.leetcode;

/**
 * 两整数之和
 */
public class LeetCode371 {

    public int getSum(int a, int b) {
//        return (a ^ b) ^ ((a & b) << 1);
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        LeetCode371 lc = new LeetCode371();
        int a = 2;
        int b = 3;
        int ret = lc.getSum(a, b);
        System.out.println(ret);
    }

}
