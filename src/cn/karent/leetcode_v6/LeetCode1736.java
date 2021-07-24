package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 替换隐藏数字得到的最晚时间
 * @author wan
 * @date 2021.07.24
 ***********************************************/
public class LeetCode1736 {

    public String maximumTime(String time) {
        char[] chs = time.trim().toCharArray();
        if( chs[0] == '?') {
            if( chs[1] != '?' && chs[1] >= '4')
                chs[0] = '1';
            else chs[0] = '2';
        }
        if( chs[1] == '?') {
            if( chs[0] == '2')
                chs[1] = '3';
            else chs[1] = '9';
        }
        if( chs[3] == '?') {
            chs[3] = '5';
        }
        if( chs[4] == '?') {
            chs[4] = '9';
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        LeetCode1736 lc = new LeetCode1736();
//        String time = "2?:?0";
        String time = "?0:15";
        String ret = lc.maximumTime(time);
        System.out.println(ret);
    }

}
