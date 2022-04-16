package cn.karent.leetcode_v7;

/*******************************************
 * @author wan
 * @date: 2022-04-16 10:46
 * @description: 最大回文数乘积
 *******************************************/
public class LeetCode479 {

    /**
     * 从大到小枚举, 一旦找到结果直接退出, 这样能减少不少枚举的次数
     * @param n
     * @return
     */
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int upper = (int)Math.pow(10, n) - 1;
        int ans = 0;
        for (int left = upper; ans == 0; --left) {
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10;  // 构造回文数
            }
            // 枚举该回文数, 判断其是否可以由两个n位数乘积得到
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) {
                    ans = (int) (p % 1337);
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode479 lc = new LeetCode479();

    }

}
