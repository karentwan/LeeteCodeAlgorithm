package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: Excel表列名称
 * @author wan
 * @date 2021.06.29
 ***********************************************/
public class LeetCode168 {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int mod = (columnNumber - 1) % 26;
            sb.append((char)(mod + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LeetCode168 lc = new LeetCode168();
        int n = 28;
//        int n = 1;
//        int n = 701;
        String ret = lc.convertToTitle(n);
        System.out.println(ret);
    }

}
