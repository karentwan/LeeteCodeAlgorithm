package cn.karent.leetcode_v5.weeklycontest244;

import java.util.*;

/********************************************
 * description: 装包裹的最小浪费空间
 * 注意: 要考虑包裹里面的同样大小的包裹
 * Debug过程: 找一份AC代码, 然后跑出错的样例, 将中间结果输出, 对比我的
 * 代码和AC代码中间结果的差别.
 * @author wan
 * @date 2021.06.06
 ********************************************/
public class Algo5779 {

    private int lt(int[] arr, int target) {
        int l = 0, r = arr.length-1;
        while (l <= r) {
            int m = l+(r-l)/2;
            if( arr[m] >= target) r = m-1;
            else l = m+1;
        }
        return r;
    }

    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        if( packages.length == 0) return 0;
        long ret = Long.MAX_VALUE;
        int mod = ((int) (1e9 + 7));
        long[] sum = new long[packages.length+1];
        for (int i = 1; i <= packages.length; i++) {
            sum[i] = sum[i-1] + packages[i-1];
        }
        for (int[] box : boxes) {
            Arrays.sort(box);
            int last = 0;
            long t = 0L;
            if( packages[packages.length-1] > box[box.length-1]) continue;
            for (int i = 0; i < box.length; i++) {
                int idx = lt(packages, box[i] + 1);
                if( idx < last) continue;
                long waste = (idx - last + 1) * (box[i] * 1L) - (sum[idx+1] - sum[last]);
                t += waste;
                last = idx + 1;
                if(last >= packages.length) break;
            }
            ret = Math.min(ret, t);
        }
        if( ret == Long.MAX_VALUE) return -1;
        return ((int) (ret % mod));
    }

    public static void main(String[] args) {
        Algo5779 lc = new Algo5779();
        int[] packages = {2, 3, 5};
        int[][] boxes = {{4,8},{2,8}};
        int ret = lc.minWastedSpace(packages, boxes);
        System.out.println(ret);
//        int[] packages = {3,5,8,10,11,12};
//        int t = 2;
//        System.out.println(lc.lt(packages, t));
    }

}
