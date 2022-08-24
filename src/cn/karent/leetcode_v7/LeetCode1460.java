package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 通过翻转子数组使两个数字相等
 * @author wan
 * @date 2022.08.24 08:42
 ******************************************/
public class LeetCode1460 {

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode1460 lc = new LeetCode1460();
    }

}
