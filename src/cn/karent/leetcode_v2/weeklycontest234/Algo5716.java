package cn.karent.leetcode_v2.weeklycontest234;

/**
 * 好因子的最大数目
 */
public class Algo5716 {

    private long quickPower(long a, long b) {
        int MOD = ((int) (1e9 + 7));
        long ret = 1;
        while (b != 0) {
            if( (b & 1) != 0) {
                ret = ret * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ret;
    }

    public int maxNiceDivisors(int primeFactors) {
        if( primeFactors <= 3) {
            return primeFactors;
        }
        int b = primeFactors / 3;
        int MOD = ((int) (1e9 + 7));
        if( primeFactors % 3 == 1) {
            return ((int) (quickPower(3, b - 1) * 4 % MOD));
        } else if( primeFactors % 3 == 2) {
            return ((int) (quickPower(3, b) * 2 % MOD));
        } else {
            return ((int) (quickPower(3, b) % MOD));
        }
    }

    public static void main(String[] args) {
        Algo5716 algo = new Algo5716();
        int primeFactors = 5;
        int ret = algo.maxNiceDivisors(primeFactors);
        System.out.println(ret);
    }

}
