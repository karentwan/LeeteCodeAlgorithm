package cn.karent.leetcode_v6;


public class LeetCode1137 {

    public int tribonacci(int n) {
        if( n <= 1) return n;
        if( n == 2) return 1;
        int a = 0, b = 1, c = 1;
        for (int i = 3; i <= n; i++) {
            int t = a + b + c;
            a = b;
            b = c;
            c = t;
        }
        return c;
    }

    public static void main(String[] args) {
        LeetCode1137 lc = new LeetCode1137();
//        int n = 4;
        int n = 25;
        int ret = lc.tribonacci(n);
        System.out.println(ret);
    }

}
