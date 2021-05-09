package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 适龄的朋友
 * @author wan
 * @date 2021.05.09
 ********************************************/
public class LeetCode825 {

    public int numFriendRequests(int[] ages) {
        int[] bucket = new int[121];
        for (int age : ages) {
            bucket[age]++;
        }
        int ret = 0;
        for (int i = 0; i < 121; i++) {
            int cntA = bucket[i];
            for (int j = 0; j < 121; j++) {
                int cntB = bucket[j];
                if( i < j) continue;
                if( j <= 0.5 * i + 7) continue;
                if( j > 100 && i < 100) continue;
                ret += cntA * cntB;
                if( i == j) ret -= cntA;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode825 lc = new LeetCode825();
//        int[] ages = {16,16};
//        int[] ages = {16,17,18};
//        int[] ages = {20,30,100,110,120};
//        int[] ages = {101,56,69,48,30};
//        int[] ages = {108,115,5,24,82};
//        int[] ages = {101,56,69,48,30};
        int[] ages = {8,85,24,85,69};
        int ret = lc.numFriendRequests(ages);
        System.out.println(ret);
    }

}
