package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 最小好进制
 * @author wan
 * @date 2021.06.18
 ********************************************/
public class LeetCode483 {

    public String smallestGoodBase(String n) {
        Long v = Long.parseLong(n);
        int mMax = ((int) (Math.log(v) / Math.log(2)));
        for (int i = mMax; i > 1; i--) {
            int k = ((int) Math.pow(v, 1.0 / i));
            long mul = 1, sum = 1;
            for (int j = 0; j < i; j++) {
                mul *= k;
                sum += mul;
            }
            if( sum == v) return Integer.toString(k);
        }
        return Long.toString(v-1);
    }

    public static void main(String[] args) {

    }

}
