package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 编码异或后的排列
 * @author wan
 * @date 2021.05.11
 ********************************************/
public class LeetCode1734 {

    public int[] decode(int[] encoded) {
        int n = encoded.length;
        if( n == 0) return new int[0];
        int[] rets = new int[n+1];
        int s = 0;
        for (int i = 1; i <= n+1; i++) {
            s ^= i;
        }
        for (int i = 1; i < n; i += 2) {
            s ^= encoded[i];
        }
        rets[0] = s;
        for (int i = 1; i <= n; i++) {
            rets[i] = s ^ encoded[i-1];
            s = s ^ encoded[i-1];
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1734 lc = new LeetCode1734();
        int[] encoded = {3,1};
        int[] rets = lc.decode(encoded);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
