package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 移动所有球到每个盒子所需的最小操作数
 * @author wan
 * @date 2021.06.08
 ********************************************/
public class LeetCode1769 {

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        char[] chs = boxes.toCharArray();
        int[] left = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            left[i] = left[i-1] + sum + chs[i-1] - '0';
            sum += chs[i-1] - '0';
        }
        int[] right = new int[n];
        sum = 0;
        for (int i = n-2; i >= 0; i--) {
            right[i] = right[i+1] + sum + chs[i+1] - '0';
            sum += chs[i+1] - '0';
        }
        for (int i = 0; i < n; i++) {
            right[i] += left[i];
        }
        return right;
    }

    public static void main(String[] args) {
        LeetCode1769 lc = new LeetCode1769();
        String boxes = "";
//        String boxes = "001011";
        int[] rets = lc.minOperations(boxes);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
