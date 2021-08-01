package cn.karent.leetcode_v6.weeklycontest252;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.08.01
 ***********************************************/
public class LeetCode5830 {

    public boolean isThree(int n) {
        if( n <= 2) return false;
        int ret = 2;
        for (int i = 2; i < n; i++) {
            if( n % i == 0) ret++;
        }
        return ret == 3;
    }

    public static void main(String[] args) {

    }

}
