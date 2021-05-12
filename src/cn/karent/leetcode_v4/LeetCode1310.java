package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 子数组异或查询
 * @author wan
 * @date 2021.05.12
 ********************************************/
public class LeetCode1310 {
/*
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preSum = new int[arr.length+1];
        for (int i = 1; i <= arr.length; i++) {
            preSum[i] = preSum[i-1] ^ arr[i-1];
        }
        int[] rets = new int[queries.length];
        for (int i = 0; i < rets.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            rets[i] = preSum[e+1] ^ preSum[s];
        }
        return rets;
    }
   */
/*

    class SegmentTree {
        private int[] data;
        private int n;
        private int[] lazy;  // 懒加载标记

        public SegmentTree(int[] arr) {
            n = arr.length;
            data = new int[n * 4];
            build(0, arr, 0, n-1);
        }

        public void build(int idx, int[] arr, int l, int r) {
            if( l == r) {
                this.data[idx] = arr[l];
                return;
            }
            int m = l + (r - l)/2;
            build(idx * 2 + 1, arr, l, m);
            build(idx * 2 + 2, arr, m+1, r);
            data[idx] = data[idx * 2 + 1] ^ data[idx * 2 + 2];
        }

        public int _query(int idx, int l, int r, int s, int e) {
            if( s <= l && e >= r) {
                return data[idx];
            }
            if( r < s || l > e) {
                return 0;
            }
            int m = l + (r-l)/2;
            int ret = _query(idx * 2 + 1, l, m, s, e);
            ret ^= _query(idx * 2 + 2, m+1, r, s, e);
            return ret;
        }

        public int query(int s, int e) {
            return _query(0, 0, n-1, s, e);
        }

    }

    // 使用线段树
    public int[] xorQueries(int[] arr, int[][] queries) {
        SegmentTree st = new SegmentTree(arr);
        int[] rets = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            rets[i] = st.query(s, e);
        }
        return rets;
    }
*/


    class TreeArray {
        private int[] data;

        private int n;

        public TreeArray(int[] arr) {
            n = arr.length+1;
            data = new int[n];
            for (int i = 1; i < n; i++) {
                update(i, arr[i-1]);
            }
        }

        public int lowbit(int x) {
            return x & -x;
        }

        public void update(int idx, int x) {
            while (idx < n) {
                data[idx] ^= x;
                idx += lowbit(idx);
            }
        }

        public int get(int idx) {
            int ret = 0;
            while (idx > 0) {
                ret ^= data[idx];
                idx -= lowbit(idx);
            }
            return ret;
        }

        public int query(int s, int e) {
            return get(e+1) ^ get(s);
        }

    }

    // 使用树状数组
    public int[] xorQueries(int[] arr, int[][] queries) {
        TreeArray st = new TreeArray(arr);
        int[] rets = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];
            int e = queries[i][1];
            rets[i] = st.query(s, e);
        }
        return rets;
    }


    public static void main(String[] args) {
        LeetCode1310 lc = new LeetCode1310();
//        int[] arr = {1, 3, 4, 8};
//        int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
        int[] arr = {4,8,2,10};
        int[][] queries = {{2,3},{1,3},{0,0},{0,3}};
        int[] rets = lc.xorQueries(arr, queries);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
