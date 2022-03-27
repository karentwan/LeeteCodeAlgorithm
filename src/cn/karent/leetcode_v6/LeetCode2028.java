package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-03-27 09:50
 * @description: 找出缺失的观测数据
 *******************************************/
public class LeetCode2028 {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean * (n + m);
        for (int roll : rolls) {
            total -= roll;
        }
        if (n == 0 || total <= 0) return new int[0];
        int x = total / n;
        int mod = total % n;
        if (x > 6 || (x == 6 && mod > 0)) return new int[0];
        int[] rets = new int[n];
        for (int i = 0; i < n; i++) {
            rets[i] = x;
            if (mod > 0) {
                rets[i] += 1;
                mod--;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode2028 lc = new LeetCode2028();
//        int[] rolls = {3,2,4,3};
//        int mean = 4, n = 2;
        int[] rolls = {1,2,3,4};
        int mean = 6, n = 4;
        int[] rets = lc.missingRolls(rolls, mean, n);
        for (int ret : rets) {
            System.out.println(ret);
        }

    }

}
