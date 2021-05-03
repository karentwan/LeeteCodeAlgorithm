package cn.karent.leetcode_v1;

/**
 * 3的幂
 */
public class LeetCode326 {

    public boolean isPowerOfThree(int n) {
        if( n < 1) {
            return false;
        }
        // Java支持浮点数求余
        // Math.log()以e为底数, 要想以10为底数, 使用Math.log10()
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
//        LeetCode326 lc = new LeetCode326();
//        int n = 45;
//        boolean ret = lc.isPowerOfThree(n);
//        System.out.println(ret);
        System.out.println(3.1 % 3.09);
    }

}
