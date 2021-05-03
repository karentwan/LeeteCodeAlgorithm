package cn.karent.leetcode_v2.weeklycontest234;

import java.util.*;

/**
 * 字符串中不同正数的数目
 */
public class Algo5713 {

    public int numDifferentIntegers(String word) {
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while ( i < word.length() ) {
            while (i < word.length() && !Character.isDigit(word.charAt(i))) {
                i++;
            }
            int tmp = i;
            int val = 0;
            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                val = val * 10 + (word.charAt(i) - '0');
                i++;
            }
            if( i > tmp) {
                set.add(val);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Algo5713 algo = new Algo5713();
//        String s = "a123bc34d8ef34";
//        String s = "leet1234code234";
        String s = "a1b01c001";
        int ret = algo.numDifferentIntegers(s);
        System.out.println(ret);
    }

}
