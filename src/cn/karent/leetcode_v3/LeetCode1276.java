package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 不浪费原料的汉堡制作方案
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1276 {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        int t1 = tomatoSlices - 2 * cheeseSlices;
        int t2 = 4 * cheeseSlices - tomatoSlices;
        List<Integer> rets = new ArrayList<>();
        if( t1 < 0 || t2 < 0) return rets;
        if( t1 % 2 != 0 || t2 % 2 != 0) return rets;
        rets.add(t1 / 2);
        rets.add(t2 / 2);
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1276 lc = new LeetCode1276();
//        int tomatoSlices = 16;
//        int cheeseSlices = 7;
//        int tomatoSlices = 17;
//        int cheeseSlices = 4;
//        int tomatoSlices = 4;
//        int cheeseSlices = 17;
//        int tomatoSlices = 0;
//        int cheeseSlices = 0;
        int tomatoSlices = 2;
        int cheeseSlices = 1;
        List<Integer> rets = lc.numOfBurgers(tomatoSlices, cheeseSlices);
        System.out.println(rets);
    }

}
