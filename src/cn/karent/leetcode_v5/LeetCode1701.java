package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 平均等待时间
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode1701 {

    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        if( n == 0) return 0;
        double ret = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if( time < customers[i][0]) {
                time = customers[i][0];
            }
            time += customers[i][1];
            ret += time - customers[i][0];
        }
        return ret / n;
    }

    public static void main(String[] args) {
        LeetCode1701 lc = new LeetCode1701();
        int[][] cus = {{1,2},{2,5},{4,3}};
        double ret = lc.averageWaitingTime(cus);
        System.out.println(ret);
    }

}
