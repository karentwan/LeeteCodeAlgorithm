package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 汉明距离
 * @author wan
 * @date 2021.05.27
 ********************************************/
public class LeetCode461 {

    public int hammingDistance(int x, int y) {
        int ret = 0;
        for(int i = 30; i >= 0; i--) {
            int t1 = x & ( 1 << i);
            int t2 = y & ( 1 << i);
            if( t1 != t2) ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode461 lc = new LeetCode461();
        int x = 1;
        int y = 4;
        int ret = lc.hammingDistance(x, y);
        System.out.println(ret);
    }

}
