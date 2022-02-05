package cn.karent.leetcode_v7;

import java.util.*;

/***********************************************
 * description: 和为k的最少斐波那契数列
 * @author wan
 * @date 2022.02.03
 ***********************************************/
public class LeetCode1414 {

    public int findMinFibonacciNumbers(int k) {
        List<Integer> f = new ArrayList<>();
        f.add(1);
        int a = 1, b = 1;
        while (a + b <= k) {
            int c = a + b;
            f.add(c);
            a = b;
            b = c;
        }
        int ans = 0;
        for (int i = f.size() - 1; i >= 0 && k > 0; i--) {
            int num = f.get(i);
            if (k >= num) {
                k -= num;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode1414 lc = new LeetCode1414();
        int k = 19;
        System.out.println(lc.findMinFibonacciNumbers(k));
    }

}
