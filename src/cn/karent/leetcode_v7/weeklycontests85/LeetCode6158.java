package cn.karent.leetcode_v7.weeklycontests85;

import java.util.*;

/******************************************
 * 字母移位 二
 * @author wan
 * @date 2022.08.21 15:14
 ******************************************/
public class LeetCode6158 {

    public String shiftingLetters(String s, int[][] shifts) {
        // 差分数组
        int[] diff = new int[s.length()+1];
        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], d = shift[2] == 0 ? -1 : 1;
            diff[start] += d;
            diff[end+1] -= d;
        }
        char[] chs = s.toCharArray();
        for (int i = 0, last = 0; i < diff.length-1; last = diff[i], i++) {
            diff[i] += last;
            chs[i] = (char) ((chs[i] - 'a' + diff[i] % 26 + 26) % 26 + 'a');
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        LeetCode6158 lc = new LeetCode6158();
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(lc.shiftingLetters(s, shifts));
    }

}
