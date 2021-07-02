package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 分糖果
 * @author wan
 * @date 2021.07.02
 ***********************************************/
public class LeetCode575 {

    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int item : candyType) {
            set.add(item);
        }
        return Math.min(set.size(), n / 2);
    }

    public static void main(String[] args) {

    }

}
