package cn.karent.leetcode_v8;

import java.util.*;

/******************************************
 * 分割圆的最少切割次数
 * @author wan
 * @date 2023.06.17 11:47
 ******************************************/
public class LeetCode2481 {

    public int numberOfCuts(int n) {
        if (n <= 1) return 0;
        return n % 2 == 0 ? n / 2 : n;
    }

    public static void main(String[] args) {
        LeetCode2481 lc = new LeetCode2481();
    }

}
