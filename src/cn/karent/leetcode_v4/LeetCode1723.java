package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 完成所有工作的最短时间
 * @author wan
 * @date 2021.05.08
 ********************************************/
public class LeetCode1723 {

/*
    private int ret;

    private void dfs(int[] jobs, int idx, int[] bucket, int mx) {
        if( idx >= jobs.length) {
            ret = Math.min(ret, mx);
            return;
        }
        for (int i = 0; i < bucket.length; i++) {
            if( bucket[i] + jobs[idx] > ret) continue;
            bucket[i] += jobs[idx];
            dfs(jobs, idx+1, bucket, Math.max(mx, bucket[i]));
            bucket[i] -= jobs[idx];
        }
    }

    // 超时
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] bucket = new int[k];
        ret = Integer.MAX_VALUE;
        dfs(jobs, 0, bucket, Integer.MIN_VALUE);
        return ret;
    }

*/

    private int ret;

    private void dfs(int[] jobs, int idx, int used, int[] bucket, int mx) {
        if( mx >= ret) return;
        if( idx >= jobs.length) {
            ret = Math.min(ret, mx);
            return;
        }
        // 优先将元素分配给空闲的工人
        if( used < bucket.length) {
            bucket[used] = jobs[idx];
            dfs(jobs, idx+1, used+1, bucket, Math.max(mx, bucket[used]));
            bucket[used] = 0;
        }
        for (int i = 0; i < used; i++) {
            bucket[i] += jobs[idx];
            dfs(jobs, idx+1, used, bucket, Math.max(mx, bucket[i]));
            bucket[i] -= jobs[idx];
        }
    }

    // 优先分配给空闲工人
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] bucket = new int[k];
        ret = Integer.MAX_VALUE;
        dfs(jobs, 0, 0, bucket, Integer.MIN_VALUE);
        return ret;
    }


    public static void main(String[] args) {
        LeetCode1723 lc = new LeetCode1723();
//        int[] jobs = {3, 2, 3};
//        int k = 3;
        int[] jobs = {1,2,4,7,8};
        int k = 2;
//        int[] jobs = {9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202};
//        int k = 9;
//        int[] jobs = {46,13,54,51,38,49,54,67,26,78,33};
//        int k = 10;
        int ret = lc.minimumTimeRequired(jobs, k);
        System.out.println(ret);
    }

}
