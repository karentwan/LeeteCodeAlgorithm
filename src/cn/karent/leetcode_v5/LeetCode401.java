package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 二进制手表
 * @author wan
 * @date 2021.06.21
 ***********************************************/
public class LeetCode401 {

    private void dfs(int turnedOn, int mask, int idx, List<String> rets) {
        int hour = (mask >> 6) & 0XF;
        if( turnedOn == 0 ) {
            int minute = mask & 0X3F;
            String s = minute < 10 ? "0" + minute : minute + "";
            if( hour < 12 && minute < 60) {
                rets.add(hour + ":" + s);
            }
            return;
        }
        // 剪枝
        if( idx < turnedOn-1 || hour > 12) return;
        for (int i = idx; i >= 0; i--) {
            dfs(turnedOn-1, mask | (1 << i), i-1, rets);
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> rets = new ArrayList<>();
        int idx = 9;
        dfs(turnedOn, 0, idx, rets);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode401 lc = new LeetCode401();
        int t = 2;
        List<String> ret = lc.readBinaryWatch(t);
        System.out.println(ret);
    }

}
