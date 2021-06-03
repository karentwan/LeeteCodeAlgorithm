package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 统计作战单位
 * @author wan
 * @date 2021.06.03
 ********************************************/
public class LeetCode1395 {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][] up = new int[n][3];
        int[][] down = new int[n][3];
        if( n == 0) return 0;
        up[0][0] = 1;
        down[0][0] = 1;
        int ret = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                up[i][0] = 1;
                down[i][0] = 1;
                if( rating[i] > rating[j]) {
                    up[i][1] += up[j][0];
                    up[i][2] += up[j][1];
                } else if( rating[i] < rating[j]) {
                    down[i][1] += down[j][0];
                    down[i][2] += down[j][1];
                }
            }
            ret = ret + up[i][2] + down[i][2];
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1395 lc = new LeetCode1395();
//        int[] rating = {2, 5, 3, 4, 1};
        int[] rating = {2,1,3};
        int ret = lc.numTeams(rating);
        System.out.println(ret);
    }

}
