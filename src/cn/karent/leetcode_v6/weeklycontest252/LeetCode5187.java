package cn.karent.leetcode_v6.weeklycontest252;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.08.01
 ***********************************************/
public class LeetCode5187 {

    private long get(long n) {
        return 2 * n * (n + 1) * (2 * n + 1);
    }

    public long minimumPerimeter(long neededApples) {
        if( neededApples <= 12) return 8;
        long n = 1;
        for (; get(n) < neededApples; n++);
        return n * 8;
    }

    public static void main(String[] args) {
        LeetCode5187 lc = new LeetCode5187();
        long need = 1000000000;
//        long need = 13;
//        long need = 1;
        long ret = lc.minimumPerimeter(need);
        System.out.println(ret);
    }

}
