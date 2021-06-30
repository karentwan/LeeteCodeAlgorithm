package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 分数到小数
 * @author wan
 * @date 2021.06.30
 ***********************************************/
public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if( numerator == 0) return "0";
        if( numerator < 0 ^ denominator < 0)
            sb.append("-");
        Long a = Math.abs(Long.valueOf(numerator));
        Long b = Math.abs(Long.valueOf(denominator));
        if( a % b == 0) {
            sb.append(a / b);
            return sb.toString();
        }
        sb.append(a / b + ".");
        Long rem = a % b;
        Map<Long, Integer> map = new HashMap<>();
        while ( rem != 0) {
            if( map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                break;
            }
            map.put(rem, sb.length());
            rem *= 10;
            sb.append(rem / b);
            rem %= b;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode166 lc = new LeetCode166();
        int numerator = -1;
        int denominator = -2147483648;
        String ret = lc.fractionToDecimal(numerator, denominator);
        System.out.println(ret);
    }

}
