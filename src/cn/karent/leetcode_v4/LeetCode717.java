package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 1比特与2比特字符
 * @author wan
 * @date 2021.05.05
 ********************************************/
public class LeetCode717 {

    private boolean dfs(int[] bits, int idx) {
        if( idx >= bits.length) return false;
        if( idx == bits.length-1) {
            return bits[idx] == 0;
        }
        if( bits[idx] == 0) return dfs(bits, idx+1);
        return dfs(bits, idx+2);
    }

    public boolean isOneBitCharacter(int[] bits) {
        return dfs(bits, 0);
    }

    public static void main(String[] args) {
        LeetCode717 lc = new LeetCode717();
//        int[] bits = {1, 0, 0};
        int[] bits = {1, 1, 1, 0};
        boolean ret = lc.isOneBitCharacter(bits);
        System.out.println(ret);
    }

}
