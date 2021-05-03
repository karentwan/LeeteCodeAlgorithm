package cn.karent.leetcode;

/**
 * 绝对值表达式的最大值
 */
public class LeetCode1131 {

    // brute force
    public int maxAbsValExpr1(int[] arr1, int[] arr2) {
        int ret = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = i + 1; j < arr2.length; j++) {
                int tmp = Math.abs(arr1[i] - arr1[j]) +
                        Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j);
                ret = Math.max(ret, tmp);
            }
        }
        return ret;
    }

    // optimize
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int ret = 0;
        int maxA = Integer.MIN_VALUE, minA = Integer.MAX_VALUE, maxB = Integer.MIN_VALUE,
                minB = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE,
                minC = Integer.MAX_VALUE, maxD = Integer.MIN_VALUE,
                minD = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            maxA = Math.max(maxA, arr1[i] + arr2[i] + i);
            minA = Math.min(minA, arr1[i] + arr2[i] + i);
            maxB = Math.max(maxB, arr1[i] - arr2[i] + i);
            minB = Math.min(minB, arr1[i] - arr2[i] + i);
            maxC = Math.max(maxC, arr2[i] - arr1[i] + i);
            minC = Math.min(minC, arr2[i] - arr1[i] + i);
            maxD = Math.max(maxD, -(arr1[i] + arr2[i] - i));
            minD = Math.min(minD, -(arr1[i] + arr2[i] - i));
        }
        ret = Math.max(maxA - minA, Math.max(maxB - minB,
                Math.max(maxC - minC, maxD - minD)));
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1131 lc = new LeetCode1131();
//        int[] arr1 = {1,2,3,4};
//        int[] arr2 = {-1,4,5,6};
        int[] arr1 = {1,-2};
        int[] arr2 = {8, 8};
        int ret = lc.maxAbsValExpr(arr1, arr2);
        System.out.println(ret);
    }
}
