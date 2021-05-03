package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 柠檬水找零
 * @author wan
 * @date 2021.04.13
 */
public class LeetCode860 {

    public boolean lemonadeChange(int[] bills) {
        int rest5 = 0, rest10 = 0, rest20 = 0;
        for (int bill : bills) {
            int r = bill - 5;
            if (r >= 10 && rest10 > 0) {
                r -= 10;
                rest10--;
            }
            while (r > 0 && rest5 > 0) {
                r -= 5;
                rest5--;
            }
            if( r > 0) return false;
            switch (bill) {
                case 5:
                    rest5++;
                    break;
                case 10:
                    rest10++;
                    break;
                case 20:
                    rest20++;
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode860 lc = new LeetCode860();
//        int[] nums = {5,5,10,10,20};
        int[] nums = {5,5,5,10,20};
        boolean ret = lc.lemonadeChange(nums);
        System.out.println(ret);
    }

}
