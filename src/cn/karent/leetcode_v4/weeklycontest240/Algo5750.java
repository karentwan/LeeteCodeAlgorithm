package cn.karent.leetcode_v4.weeklycontest240;

import java.util.*;

/********************************************
 * description: 人口最多的年份
 * @author wan
 * @date 2021.05.09
 ********************************************/
public class Algo5750 {

    public int maximumPopulation(int[][] logs) {
        int n = 2050 - 1950 + 1;
        int[] date = new int[n];
        for (int[] log : logs) {
            for (int i = log[0] - 1950; i < log[1] - 1950; i++) {
                date[i]++;
            }
        }
        int mx = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if( date[i] > mx) {
                mx = date[i];
                ret = i + 1950;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5750 lc = new Algo5750();
        int[][] logs = {{1993,1999},{2000,2010}};
        int ret = lc.maximumPopulation(logs);
        System.out.println(ret);
    }

}
