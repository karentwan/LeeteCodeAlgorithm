package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 分数到小数
 * @author wan
 * @date 2021.10.03
 ***********************************************/
public class LeetCode166 {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator;
        long b = denominator;
        if( a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        if( a < 0 ^ b < 0) {  // 只要一个true一个false就会为true
            sb.append("-");
        }
        a = Math.abs(a); b = Math.abs(b);
        sb.append(a / b);  // 整数部分
        long remainder = a % b;  // 余数, 开始求小数
        Map<Long, Integer> map = new HashMap<>();
        sb.append(".");  // 添加小数点
        int idx = sb.length();
        while ( remainder != 0 && !map.containsKey(remainder)) {
            map.put(remainder, idx);
            remainder *= 10;
            sb.append(remainder / b);
            remainder = remainder % b;
            idx++;
        }
        if( remainder != 0) {  // 出现了循环节
            Integer index = map.get(remainder);
            sb.insert(index, "(");
            sb.append(")");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // Java 布尔值也可以异或 true = 1, false = 0, 位运算的规则如上
//        System.out.println("bool值异或: " + (false & true));
        LeetCode166 lc = new LeetCode166();
//        int a = 2, b = 3;
//        int a = 2, b = 1;
//        int a = 1, b = 2;
        int a = 4, b = 333;
        String ret = lc.fractionToDecimal(a, b);
        System.out.println(ret);
    }

}
