package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 整数转罗马数字
 * @author wan
 * @date 2021.05.14
 ********************************************/
public class LeetCode12 {

    private int[] numbers =  { 1,  4,     5,   9,  10,  40,    50,  90,    100, 400,  500, 900, 1000};
    private String[] roman = {"I", "IV", "V", "IX","X", "XL", "L",  "XC", "C",  "CD", "D",  "CM", "M" };

    // 寻找小于等于target的下标
    private int binarySearch(int target) {
        int l = 0, r = numbers.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if( numbers[m] == target) return m;
            else if(numbers[m] > target) r = m-1;
            else l = m+1;
        }
        return Math.max(r, 0);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int idx = binarySearch(num);
            sb.append(roman[idx]);
            num -= numbers[idx];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode12 lc = new LeetCode12();
//        int n = 3;
        int n = 1;
        String ret = lc.intToRoman(n);
        System.out.println(ret);
    }

}
