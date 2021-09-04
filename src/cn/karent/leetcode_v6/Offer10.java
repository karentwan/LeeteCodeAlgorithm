package cn.karent.leetcode_v6;

public class Offer10 {

    private int[][] multiply(int[][] a, int[][] b) {
        int m1 = a.length, m2 = b.length;
        int mod = 1000_000_007;
        // 判断是否能够进行矩阵相乘
        if (m1 == 0 || m2 == 0 )
            return new int[0][0];
        int n1 =a[0].length, n2 = b[0].length;
        if( n1 != m2)
            return new int[0][0];
        int[][] rets = new int[m1][n2];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n1; k++) {
                    rets[i][j] = ((int) ((rets[i][j] + (a[i][k] * b[k][j] * 1L) % mod) % mod));
                }
            }
        }
        return rets;
    }

    private int[][] quickPower(int[][] x, int p) {
        int[][] ret = {{1,0},{0,1}};
        while (p > 0) {
            if( (p & 1) != 0) {
                ret = multiply(ret, x);
            }
            x = multiply(x, x);
            p >>= 1;
        }
        return ret;
    }

    public int fib(int n) {
        if( n < 2)
            return n;
        int[][] base = {{1,1},{1,0}};
        int[][] p = quickPower(base, n-1);
        int[][] rets = multiply(p, new int[][]{{1},{0}});
        return rets[0][0];
    }

    /**
     * 快速幂
     *
     * @param x
     * @param p
     * @return
     */
    public int quickPow(int x, int p) {
        int ret = 1;
        while (p > 0) {
            if ((p & 1) != 0) {
                ret *= x;
            }
            x *= x;
            p >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        Offer10 lc = new Offer10();
//        int[][] a = {{1,1},{1,1}};
//        int[][] b = {{2,3},{4,4}};
//        int[][] ret = lc.multiply(a, b);
//        for (int[] item : ret) {
//            for (int i : item) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        System.out.println(lc.quickPow(2, 0));
        int n = 43;
        int ret = lc.fib(n);
        System.out.println(ret);

    }

}
