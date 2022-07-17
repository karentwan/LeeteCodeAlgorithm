package cn.karent.leetcode_v6.weeklycontest302;

import java.util.*;

/******************************************
 * 使数组可以被整除的最少删除次数
 * @author wan
 * @date 2022.07.17 11:29
 ******************************************/
public class LeetCode6122 {

    private int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a%b);
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        // 1. 求numsDivide得最大公约数
        Arrays.sort(numsDivide);
        int g = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            g = gcd(numsDivide[i], g);
        }
        // 2. 求nums所有元素中最小可以被g整除的元素
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= g; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            if (g % nums[i] == 0) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode6122 lc = new LeetCode6122();
//        int[] nums = {2, 3, 2, 4, 3};
//        int[] numsDivide = {9,6,9,3,15};
        int[] nums = {4,3,6};
        int[] numsDivide = {8,2,6,10};
        System.out.println(lc.minOperations(nums, numsDivide));
    }

}
