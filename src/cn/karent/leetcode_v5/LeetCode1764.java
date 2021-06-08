package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 通过连接另一个数组的子数组得到另一个数组
 * @author wan
 * @date 2021.06.08
 ********************************************/
public class LeetCode1764 {

    // 使用kmp算法进行匹配
    private int kmp(int[] arr, int[] arr2, int s) {
        int[] next = new int[arr.length];
        next[0] = -1;  // 生成next数组
        int i = 0, j = 1;
        while ( j < arr.length - 1) {
            if( i == -1 || arr[i] == arr[j]) next[++j] = ++i;
            else i = next[i];
        }
        i = 0;
        j = s;
        while (i < arr.length && j < arr2.length) {
            if( i == -1 || arr[i] == arr2[j]) {
                i++;
                j++;
            } else {
                i = next[i];
            }
        }
        return i >= arr.length ? j : -1;
    }

    public boolean canChoose(int[][] groups, int[] nums) {
        int n = groups.length;
        for (int i = 0, j = 0; i < n; i++) {
            j = kmp(groups[i], nums, j);
            if( j == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1764 lc = new LeetCode1764();
        int[][] groups = {{1,-1,-1},{3,-2,0}};
        int[] arr = {1, -1, 0, 1, -1, -1, 3, -2, 0};
        boolean ret = lc.canChoose(groups, arr);
        System.out.println(ret);
    }

}
