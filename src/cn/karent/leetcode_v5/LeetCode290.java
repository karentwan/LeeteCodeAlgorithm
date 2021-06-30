package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 单词规律
 * @author wan
 * @date 2021.06.30
 ***********************************************/
public class LeetCode290 {

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        Map<String, Character> map = new HashMap<>();
        Map<Character, String> reverse = new HashMap<>();
        if( strs.length != pattern.length()) return false;
        for (int i = 0; i < strs.length; i++) {
            if( map.containsKey(strs[i]) ) {
                if( map.get(strs[i]) != pattern.charAt(i) )
                    return false;
            } else if( reverse.containsKey(pattern.charAt(i))) {
                return false;
            }
            map.put(strs[i], pattern.charAt(i));
            reverse.put(pattern.charAt(i), strs[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode290 lc = new LeetCode290();
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean ret = lc.wordPattern(pattern, str);
        System.out.println(ret);
    }

}
