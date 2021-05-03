package cn.karent.leetcode;

import java.util.*;

/**
 * 等价多米诺骨牌对的数量
 */
public class LeetCode1128 {

    public int numEquivDominoPairs1(int[][] dominoes) {
        int ret = 0;
        for(int i = 0; i < dominoes.length; i++) {
            guarantee(dominoes, i);
        }
        Arrays.sort(dominoes, (int[] a, int [] b) -> {
            if( a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int i = 0, j = 0;
        while( j < dominoes.length ) {
            while( j < dominoes.length && dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                j++;
            }
            ret += ((j - i) * (j - i - 1)) / 2;
            i = j;
        }
        return ret;
    }

    private void guarantee(int[][] dominoes, int i) {
        int[] domino = dominoes[i];
        if( domino[0] > domino[1]) {
            int tmp = domino[0];
            domino[0] = domino[1];
            domino[1] = tmp;
        }
    }

    /**
     * 先将不同的两个元素加权和, 得到一个数字, 然后统计即可
     * @param dominoes
     * @return
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int ret = 0;
        int[] map = new int[100];  // 元素最大到9, 所以100足以
        for(int[] domino : dominoes) {
            int a = domino[0];
            int b = domino[1];
            if( a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            map[a * 10 + b] ++;
        }
        for(int i = 0; i < 100; i++) {
            ret += ( map[i] * (map[i] - 1)) / 2;
        }
        return ret;
    }

}
