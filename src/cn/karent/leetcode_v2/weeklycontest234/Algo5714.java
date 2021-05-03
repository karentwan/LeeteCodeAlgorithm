package cn.karent.leetcode_v2.weeklycontest234;

import java.util.*;
import cn.karent.util.*;

/**
 * 替换字符串中的括号内容
 */
public class Algo5714 {

    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> strings : knowledge) {
            map.put(strings.get(0), strings.get(1));
        }
        int i = 0;
        StringBuilder ret = new StringBuilder();
        while (i < s.length() ) {
            if( s.charAt(i) == '(') {
                StringBuilder tmp = new StringBuilder();
                i++;
                while (i < s.length() && s.charAt(i) != ')') {
                    tmp.append(s.charAt(i));
                    i++;
                }
                ret.append(map.getOrDefault(tmp.toString(), "?"));
            } else {
                ret.append(s.charAt(i));
            }
            i++;
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Algo5714 algo = new Algo5714();
//        String[][] strs = {{"name","bob"},{"age","two"}};
//        String s = "(name)is(age)yearsold";
//        String[][] strs = {{"a","b"}};
//        String s = "hi(name)";
        String[][] strs = {{"a","yes"}};
        String s = "(a)(a)(a)aaa";
        List<List<String>> knowledge = LeetCodeUtil.arr2list(strs);
        String ret = algo.evaluate(s, knowledge);
        System.out.println(ret);
    }

}
