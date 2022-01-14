package cn.karent.leetcode_v6;

/**
 * 计算LeetCode银行的钱
 */
public class LeetCode1716 {

//    public int totalMoney(int n) {
//        int ret = 0;
//        for (int i = 1, start = 1, cnt = 0, t = 1; i <= n; i++, t++, cnt++) {
//            if (cnt % 7 == 0) {
//                cnt = 0;
//                t = start++;
//            }
//            ret += t;
//        }
//        return ret;
//    }

    public int totalMoney(int n) {
        int t = n / 7;
        int mod = n % 7;
        int a1 = 28;
        int an = a1 + (t-1) * 7;
        int ret = (a1 + an) * t / 2 + (2 * t + mod + 1) * mod / 2;
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1716 lc = new LeetCode1716();
        int n = 4;
        System.out.println(lc.totalMoney(n));
    }

}
