package cn.karent.leetcode_v4.weeklycontest239;

import java.util.*;

/********************************************
 * description: 将字符串拆分为递减的连续值
 * @author wan
 * @date 2021.05.02
 ********************************************/
public class Algo5747 {

    private boolean dfs(char[] chs, long prev, int idx, int n) {
        if( idx >= chs.length) return n >= 2;
        long ret = 0;
        for (int i = idx; i < chs.length; i++) {
            ret = ret * 10 + (chs[i] - '0');
            if( prev != Integer.MAX_VALUE && ret > prev) return false;
            if( prev != Integer.MAX_VALUE && prev != ret + 1) continue;
            if( dfs(chs, ret, i+1, n+1)) return true;
        }
        return false;
    }

    public boolean splitString(String s) {
        char[] chs = s.toCharArray();
        return dfs(chs, Integer.MAX_VALUE, 0, 0);
    }

    public static void main(String[] args) {
        Algo5747 lc = new Algo5747();
//        String s = "050043";
//        String s = "9080701";
        String s = "10009998";
        boolean ret = lc.splitString(s);
        System.out.println(ret);
    }

}
