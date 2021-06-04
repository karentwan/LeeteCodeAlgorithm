package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 和为奇数的子数组数目
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class LeetCode1524 {

    public int numOfSubarrays(int[] arr) {
        int ret = 0;
        int MOD = ((int) (1e9 + 7));
        int odd = 0, even = 1;
        int sum = 0;
        for (int item : arr) {
            sum += item;
            ret = (ret + (sum % 2 == 0 ? odd : even)) % MOD;
            if( sum % 2 == 0) even++;
            else odd++;
        }
        return ret;
    }

    public static void main(String[] args) {

    }

}
