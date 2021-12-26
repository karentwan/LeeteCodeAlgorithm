package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

public class LeetCode1078 {

    public String[] findOcurrences(String text, String first, String second) {
        String[] strs = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 2; i < strs.length; i++) {
            if (strs[i-1].equals(second) && strs[i-2].equals(first)) {
                list.add(strs[i]);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        LeetCode1078 lc = new LeetCode1078();
//        String text = "alice is a good girl she is a good student";
//        String first = "a";
//        String second = "good";
        String text = "we will we will rock you";
        String first = "we";
        String second = "will";
        String[] rets = lc.findOcurrences(text, first, second);
        LeetCodeUtil.print(rets);
    }

}
