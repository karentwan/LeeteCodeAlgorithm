package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 检查一个字符串是否可以打破另一个字符串
 * @author wan
 * @date 2021.04.17
 */
public class LeetCode1433 {

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        Arrays.sort(chs1);
        Arrays.sort(chs2);
        boolean a = true, b = true;
        for (int i = 0; i < chs1.length; i++) {
            a = a && chs1[i] >= chs2[i];
            b = b && chs1[i] <= chs2[i];
        }
        return a || b;
    }

    public static void main(String[] args) {
        LeetCode1433 lc = new LeetCode1433();
//        String s1 = "abc";
//        String s2 = "xya";
//        String s1 = "abe";
//        String s2 = "acd";
        String s1 = "leetcodee";
        String s2 = "interview";
        boolean ret = lc.checkIfCanBreak(s1, s2);
        System.out.println(ret);
    }

}
