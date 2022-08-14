package cn.karent.leetcode_v7.weeklycontest306;

import java.util.*;

/******************************************
 * 根据模式串构造最小数字
 * @author wan
 * @date 2022.08.14 10:57
 ******************************************/
public class LeetCode6150 {

    public String smallestNumber(String pattern) {
        pattern = pattern + "I";
        char[] chs = pattern.toCharArray();
        Deque<Integer> st = new ArrayDeque<>();
        Deque<Integer> vice = new ArrayDeque<>();
        for (int i = 1; i <= chs.length; i++) {
            if (st.isEmpty() || chs[i-2] == 'I') {
                st.offerLast(i);
            } else {
                vice.clear();
                for (int j = i-2; j >= 0 && !st.isEmpty() && chs[j] == 'D'; j--) {
                    vice.offerLast(st.pollLast());
                }
                st.offerLast(i);
                while (!vice.isEmpty()) {
                    st.offerLast(vice.pollLast());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode6150 lc = new LeetCode6150();
        String s = "IIIDIDDD";
        System.out.println(lc.smallestNumber(s));
    }

}
