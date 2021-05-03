package cn.karent.leetcode_v3.weeklycontest236;

import java.util.*;

/**
 * 数组元素积的符号
 * @author wan
 * @date 2021.04.11
 */
public class Algo5726 {

    public int arraySign(int[] nums) {
        int sum = 1;
        for (int num : nums) {
            if( num == 0) {
                return 0;
            }
            sum *= num > 0 ? 1 : -1;
        }
        return sum > 0 ? 1 : -1;
    }

    public static void main(String[] args) {
        Algo5726 lc = new Algo5726();
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        int ret = lc.arraySign(nums);
        System.out.println(ret);
    }

}
