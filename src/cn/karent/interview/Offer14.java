package cn.karent.interview;


/**
 * 剪绳子 二
 */
public class Offer14 {

    /**
     * 快速幂算法
     * @param a
     * @param b
     * @param MOD
     * @return
     */
    private long quickPow(long a, long b, int MOD) {
        long ret = 1;
        while( b != 0) {
            if( (b & 1) != 0) {
                ret *= a;
                ret = ret % MOD;
            }
            b >>= 1;
            a *= a;
            a = a % MOD;
        }
        return ret;
    }

    public int cuttingRope(int n) {
        int MOD = (int)1e9+7;
        if( n <= 3 ) {
            return n-1;
        }
        int a = n / 3;
        int b = n % 3;
        if( b == 0) {
            return (int)(quickPow(3, a, MOD));
        } else if( b == 1) {
            return (int)((quickPow(3, a-1, MOD) * 4) % MOD);
        } else {
            return (int)((quickPow(3, a, MOD) * 2) % MOD);
        }
    }

    public static void main(String[] args) {
        Offer14 offer = new Offer14();
        int n = 120;
        int ret = offer.cuttingRope(n);
        System.out.println(ret);
//        System.out.println(offer.quickPow(2, 3));

    }

}
