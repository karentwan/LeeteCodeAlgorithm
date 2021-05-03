package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 数组嵌套
 * @author wan
 * @date 2021.05.03
 ********************************************/
public class LeetCode565 {

    public int arrayNesting(int[] nums) {
        int ret = 0;
        int i = 0, n = nums.length;
        while (i < n) {
            if( nums[i] != -1) {
                int t = 1;
                int next = nums[i];
                int cur = i;
                nums[cur] = -1;
                while (next != i) {
                    t++;
                    cur = next;
                    next = nums[cur];
                    nums[cur] = -1;
                }
                ret = Math.max(ret, t);
            }
            i++;
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode565 lc = new LeetCode565();
        int[] A = {5, 4, 0, 3, 1, 6, 2};
        int ret = lc.arrayNesting(A);
        System.out.println(ret);
    }

}
