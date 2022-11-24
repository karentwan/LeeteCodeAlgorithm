package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 找到最高海拔
 * @author wan
 * @date 2022.11.24 16:35
 ******************************************/
public class LeetCode1732 {

    public int largestAltitude(int[] gain) {
        int ret = 0, cur = 0;
        for (int i = 0; i < gain.length; i++) {
            ret = Math.max(ret, cur += gain[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1732 lc = new LeetCode1732();

    }

}
