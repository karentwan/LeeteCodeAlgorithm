package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 分割平衡字符串
 * @author wan
 * @date 2021.04.18
 */
public class LeetCode1221 {

    public int balancedStringSplit(String s) {
        int ret = 0;
        int wnd = 0;
        for (int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == 'L') wnd++;
            else wnd--;
            if( wnd == 0) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1221 lc = new LeetCode1221();
//        String s = "RLRRLLRLRL";
//        String s = "RLLLLRRRLR";
        String s = "LLLLRRRR";
        int ret = lc.balancedStringSplit(s);
        System.out.println(ret);
    }

}
