package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 复数乘法
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode537 {

    private int[] split(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) != '+') {
            i++;
        }
        String a = s.substring(0, i);
        String b = s.substring(i+1, s.length()-1);
        return new int[]{Integer.parseInt(a), Integer.parseInt(b)};
    }

    public String complexNumberMultiply(String num1, String num2) {
        int[] n1 = split(num1);
        int[] n2 = split(num2);
        int a = n1[0] * n2[0] - n1[1] * n2[1];
        int b = n1[1] * n2[0] + n1[0] * n2[1];
        String ret = a + "+" + b + "i";
        return ret;
    }

    public static void main(String[] args) {
        LeetCode537 lc = new LeetCode537();
        String num1 = "1+-1i";
        String num2 = "1+-1i";
        String ret = lc.complexNumberMultiply(num1, num2);
        System.out.println(ret);
    }

}
