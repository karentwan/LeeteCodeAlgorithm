package cn.karent.leetcode_v2.weeklycontest49;

import java.util.*;

/**
 * 判断国际象棋棋盘中一个格子的颜色
 * @author wan
 * @date 2021.04.06
 */
public class LeetCode1812 {

    private int[] get(String s) {
        char[] chs = s.toCharArray();
        return new int[]{chs[0] - 'a', chs[1] - '1'};
    }

    public boolean squareIsWhite(String coordinates) {
        int[] points = get(coordinates);
        return !((points[0] % 2 == 0 && points[1] % 2 == 0) ||
                (points[0] % 2 != 0 && points[1] % 2 != 0));
    }

    public static void main(String[] args) {
        LeetCode1812 lc = new LeetCode1812();
        String s = "h8";
        boolean ret = lc.squareIsWhite(s);
        System.out.println(ret);
    }

}
