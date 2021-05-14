package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 卡牌分组
 * @author wan
 * @date 2021.05.14
 ********************************************/
public class LeetCode914 {

    private int _gcd(int a, int b) {
        if( b == 0) return a;
        return _gcd(b, a % b);
    }

    private int gcd(int a, int b) {
        if( a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return _gcd(a, b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        int[] cnts = new int[10000];
        for (int item : deck) {
            cnts[item]++;
        }
        int g = -1;
        for (int i = 0; i < 10000; i++) {
            if( cnts[i] != 0) {
                if( g == -1) {
                    g = cnts[i];
                } else {
                    g = gcd(cnts[i], g);
                }
            }
        }
        return g >= 2;
    }

    public static void main(String[] args) {
        LeetCode914 lc = new LeetCode914();
//        int[] arr = {1, 2, 3, 4, 4, 3, 2, 1};
//        int[] arr = {1,1,1,2,2,2,3,3};
//        int[] arr = {1};
//        int[] arr = {};
//        int[] arr = {1,1,2,2,2,2};
//        int[] arr = {0,0,0,1,1,1,2,2,2};
        int[] arr = {0,0,0,0,0,0};
        boolean ret = lc.hasGroupsSizeX(arr);
        System.out.println(ret);
    }

}
