package cn.karent.leetcode_v4.weeklycontest239;

import java.util.*;

/********************************************
 * description: 邻位交换的最小次数
 * @author wan
 * @date 2021.05.02
 ********************************************/
public class Algo5749 {

    private void swap(char[] tmps, int x, int y) {
        char t = tmps[x];
        tmps[x] = tmps[y];
        tmps[y] = t;
    }

    private void reverse(char[] tmps, int s) {
        int i = s, j = tmps.length-1;
        while (i < j) {
            swap(tmps, i++, j--);
        }
    }

    private void nextPermutation(char[] tmps) {
        int n = tmps.length;
        int i = n-2;
        while (i >= 0 && tmps[i] >= tmps[i+1]) i--;
        if( i >= 0) {
            int j = n-1;
            while (tmps[j] <= tmps[i]) j--;
            swap(tmps, i, j);
        }
        reverse(tmps, i+1);
    }

    public int getMinSwaps(String num, int k) {
        char[] chs = num.toCharArray();
        char[] tmps = Arrays.copyOf(chs, chs.length);
        while (k-- > 0) {
            nextPermutation(tmps);
        }
        int i = 0;
        while (i < chs.length && chs[i] == tmps[i]) i++;
        int ret = 0;
        for (; i < chs.length; i++) {
            int j = i;
            while (j < chs.length && chs[j] != tmps[i]) {
                j++;
            }
            char t = chs[j];
            j--;
            while ( j >= i) {
                ret++;
                chs[j+1] = chs[j];
                j--;
            }
            chs[j+1] = t;
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5749 lc = new Algo5749();
//        String num = "5489355142";
//        int k = 4;
        String num = "11112";
        int k = 4;
//        String num = "00123";
//        int k = 1;
        int ret = lc.getMinSwaps(num, k);
        System.out.println(ret);
    }

}
