package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 和为k的最少斐波那契数字数目
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode1414 {

    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1;
        List<Integer> fibos = new ArrayList<>(Arrays.asList(a, b));
        while ( a + b <= k) {
            int t = a + b;
            fibos.add(t);
            a = b;
            b = t;
        }
        int ret = 0;
        for(int i = fibos.size()-1; i >= 0 && k > 0; i--) {
            if( k >= fibos.get(i)) {
                ret++;
                k -= fibos.get(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1414 lc = new LeetCode1414();
        int k = 7;
        int ret = lc.findMinFibonacciNumbers(k);
        System.out.println(ret);
    }

}
