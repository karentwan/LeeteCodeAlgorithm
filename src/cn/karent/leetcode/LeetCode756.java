package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 金字塔转换矩阵
 */
public class LeetCode756 {

    private Map<String, List<String>> map = new HashMap<>();

    private boolean dfs(StringBuilder bottom, StringBuilder top) {
        if( bottom.length() == 2 && top.length() == 1) {
            return true;
        } else if( bottom.length() == top.length()+1) {
            return dfs(top, new StringBuilder());
        }
        String base = bottom.substring(top.length(), top.length()+2);
        List<String> values = map.getOrDefault(base, null);
        if( values == null) {
            return false;
        }
        for(String value : values) {
            top.append(value);
            if( dfs(bottom, top) ) {
                return true;
            }
            top.deleteCharAt(top.length()-1);
        }
        return false;
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for(String s : allowed) {
//            map.put(s.substring(0, 2), s.substring(2, 3));
            String key = s.substring(0, 2);
            String value = s.substring(2, 3);
            map.computeIfAbsent(key, (k)->new ArrayList<>()).add(value);
        }
        return dfs(new StringBuilder(bottom), new StringBuilder());
    }

    public static void main(String[] args) {
        LeetCode756 lc = new LeetCode756();
//        String bottom = "BCD";
//        String[] arr = {"BCG", "CDE", "GEA", "FFF"};
        String bottom = "AABA";
        String[] arr = {"AAA", "AAB", "ABA", "ABB", "BAC"};
        List<String> allowed = LeetCodeUtil.arr2list(arr);
        boolean ret = lc.pyramidTransition(bottom, allowed);
        System.out.println(ret);
    }
}
