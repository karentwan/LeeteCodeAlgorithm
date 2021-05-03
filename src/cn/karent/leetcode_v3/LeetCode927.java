package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 三等分
 * @author wan
 * @date 2021.04.14
 */
public class LeetCode927 {
/*

    private int count(int[] A, long v) {
        long t = 0;
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            t = t * 2 + A[i];
            if( t >= v) {
                cnt++;
                t = 0;
            }
        }
        return cnt;
    }

    // 当A的数组长度特别长的时候会超过范围
    public int[] threeEqualParts(int[] A) {
        int n = A.length;
        if( n == 0) return new int[]{-1,-1};
        long l = 0, r = (1 << n) - 1;
        int i = -1, j = -1;
        int cnt = 0;
        boolean flag = true;
        for (int i1 : A) {
            if(i1 != 0) {
                flag = false;
                break;
            }
        }
        // 如果全为0的情况, 直接返回任意范围
        if( flag ) return new int[]{0, A.length-1};
        while (l < r) {
            long m = l + ( r - l)/2;
            if( count(A, m) < 3) {
                r = m;
            } else {
                l = m+1;
            }
        }
        l--;
        System.out.println("nums:" + l);
        int t = 0;
        cnt = 0;
        flag = false;
        for (int k = 0; k < n; k++) {
            t = t * 2 + A[k];
            if( t == l) {
                if( i == -1) {
                    i = k;
                } else if( j == -1){
                    j = k+1;
                }
                t = 0;
                cnt++;
                if( cnt == 3 && k == n-1) flag = true;
            }
        }
        return flag ? new int[]{i, j} : new int[]{-1, -1};
    }
*/

    public int[] threeEqualParts(int[] arr) {
        int s = 0;
        int n = arr.length;
        int[] rets = new int[]{-1, -1};
        for (int i : arr) {
            s += i;
        }
        if( s % 3 != 0) return rets;
        int t = s / 3;
        if( t == 0) return new int[]{0, n-1};
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0, i3 = 0, j3 = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if( arr[i] == 1) {
                cnt += 1;
                if( cnt == 1) i1 = i;
                if( cnt == t) j1 = i;
                if( cnt == t+1) i2 = i;
                if( cnt == 2 * t) j2 = i;
                if( cnt == 2 * t + 1) i3 = i;
                if( cnt == 3 * t) j3 = i;
            }
        }
        int[] part1 = Arrays.copyOfRange(arr, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3+1);
        if( !Arrays.equals(part1, part2)) return rets;
        if( !Arrays.equals(part2, part3)) return rets;
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = n - j3 - 1;
        if( x < z || y < z) return rets;
        rets[0] = j1+z;
        rets[1] = j2+z+1;
        return rets;
    }

    public static void main(String[] args) {
        LeetCode927 lc = new LeetCode927();
//        int[] nums = {1,0,1,0,1};
//        int[] nums = {1,1,0,1,1};
//        int[] nums = {1,0,1,1,0};
//        int[] nums = {0,0,0,0,0,0};
//        int[] nums = {1,1,1,1, 1,1,0,1, 1,1};
//        int[] nums = {1,1,1,0, 0,1,1,0, 1,0,1,1, 1,1,1,1};
//        int[] nums = {0,0,0};
        int[] nums = {0,1,0,0, 1,1,0,1, 0,1,1,1, 1,0,1,0, 1,1,0,0, 1,0,0,1, 1,0,1,1, 0,1,1,0, 1,0,1,0, 0,1,1,0, 1,0,1,1, 1,1,0,1,0,1,1,0,0,1,0,0,1,1,0,1,1,0,1,1,0,1,0,1,0,0,1,1,0,1,0,1,1,1,1,0,1,0,1,1,0,0,1,0,0,1,1,0,1,1,0,1,1,0,1,0};
        int[] rets = lc.threeEqualParts(nums);
        System.out.println("(" + rets[0] + ", " + rets[1] + ")");
    }

}
