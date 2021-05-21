package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 复写零
 * @author wan
 * @date 2021.05.21
 ********************************************/
public class LeetCode1089 {

    public void duplicateZeros(int[] arr) {
        List<Integer> tmps = new ArrayList<>();
        for (int item : arr) {
            tmps.add(item);
            if( item == 0) {
                tmps.add(0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tmps.get(i);
        }
    }

    public static void main(String[] args) {
        LeetCode1089 lc = new LeetCode1089();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        lc.duplicateZeros(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

}
