package cn.karent.leetcode_v3.weeklycontest238;

import java.util.*;

/********************************************
 * description: 所有元音按顺序排布的最长字符串
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class Algo5740 {

    private int get(char ch) {
        int ret = 0;
        switch( ch ) {
            case 'a':
                ret = 0;
                break;
            case 'e':
                ret = 1;
                break;
            case 'i':
                ret = 2;
                break;
            case 'o':
                ret = 3;
                break;
            case 'u':
                ret = 4;
                break;
        }
        return ret;
    }

    private boolean beautiful(int[] cache) {
        for (int i = 0; i < cache.length; i++) {
            if( cache[i] == 0) return false;
        }
        return true;
    }

    public int longestBeautifulSubstring(String word) {
        int j = 0;
        int ret = 0;
        char[] chs = word.toCharArray();
        int[] cache = new int[5];
        for (int i = 0; i < chs.length; i++) {
            cache[get(chs[i])]++;
            if( i > 0 && chs[i] >= chs[i-1]) {
                if( beautiful(cache)) {
                    ret = Math.max(ret, i - j + 1);
                }
            } else {
                while (j < i) {
                    cache[get(chs[j])]--;
                    j++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5740 lc = new Algo5740();
//        String s = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        String s = "aeeeiiiioooauuuaeiou";
        int ret = lc.longestBeautifulSubstring(s);
        System.out.println(ret);
    }

}
