package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 从英文中重建数字
 * @author wan
 * @date 2021.07.03
 ***********************************************/
public class LeetCode423 {

    public String originalDigits(String s) {
        int[] cache = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cache[s.charAt(i)]++;
        }
        int[] cnts = new int[10];
        cnts[0] = cache['z'];
        cnts[1] = cache['o'] - cache['w'] - cache['u'] - cache['z'];
        cnts[2] = cache['w'];
        cnts[3] = cache['h'] - cache['g'];
        cnts[4] = cache['u'];
        cnts[5] = cache['f'] - cache['u'];
        cnts[6] = cache['x'];
        cnts[7] = cache['s'] - cache['x'];
        cnts[8] = cache['g'];
        cnts[9] = cache['i'] - cache['f'] + cache['u'] - cache['x'] - cache['g'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < cnts[i]; j++) {
                sb.append(i + "");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode423 lc = new LeetCode423();
//        String s = "owoztneoer";
        String s = "zeroonetwothreefourfivesixseveneightnine";
        String ret = lc.originalDigits(s);
        System.out.println(ret);
    }

}
