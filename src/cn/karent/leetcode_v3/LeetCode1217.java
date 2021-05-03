package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 玩筹码
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1217 {

    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < position.length; i++) {
            if( position[i] % 2 == 0) even++;
            else odd++;
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        LeetCode1217 lc = new LeetCode1217();
        int[] position = {1,2,3};
        int ret = lc.minCostToMoveChips(position);
        System.out.println(ret);
    }

}
