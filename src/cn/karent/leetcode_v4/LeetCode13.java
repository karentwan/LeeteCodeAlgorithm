package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 罗马数字转整数
 * @author wan
 * @date 2021.05.15
 ********************************************/
public class LeetCode13 {

    private int[] numbers =  { 1,  4,     5,   9,  10,  40,    50,  90,    100, 400,  500, 900, 1000};
    private String[] roman = {"I", "IV", "V", "IX","X", "XL", "L",  "XC", "C",  "CD", "D",  "CM", "M" };


    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(roman[i], numbers[i]);
        }
        char[] chs = s.toCharArray();
        int ret = 0;
        String s1, s2;
        for (int i = 0; i < chs.length; i++) {
            s1 = chs[i] + "";
            if( i + 1 < chs.length && map.containsKey((s2 = s1 + chs[i+1]))) {
                ret += map.get(s2);
                i++;
            } else if(map.containsKey(s1)){
                ret += map.get(s1);
            } else {
                return 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode13 lc = new LeetCode13();
//        String s = "III";
        String s = "IV";
        int ret = lc.romanToInt(s);
        System.out.println(ret);
    }

}
