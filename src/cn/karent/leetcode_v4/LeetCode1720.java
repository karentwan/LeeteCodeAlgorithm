package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 解码异或后的数组
 * @author wan
 * @date 2021.05.06
 ********************************************/
public class LeetCode1720 {

    public int[] decode(int[] encoded, int first) {
        int[] rets = new int[encoded.length+1];
        rets[0] = first;
        for (int i = 1; i <= encoded.length; i++) {
            rets[i] = first ^ encoded[i-1];
            first = rets[i];
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1720 lc = new LeetCode1720();
//        int[] encoded = {1,2,3};
//        int first = 1;
        int[] encoded = {6,2,7,3};
        int first = 4;
        int[] rets = lc.decode(encoded, first);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
