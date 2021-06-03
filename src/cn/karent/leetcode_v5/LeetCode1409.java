package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 查询带键的排列
 * @author wan
 * @date 2021.06.03
 ********************************************/
public class LeetCode1409 {

    class TreeArray {
        private int[] data;

        private int n;

        public TreeArray(int n) {
            this.n = n + 1;
            data = new int[this.n];
        }

        private int lowbit(int idx) {
            return idx & (-idx);
        }

        public void update(int idx, int val) {
            for (int i = idx; i < n; i += lowbit(i)) {
                data[i] += val;
            }
        }

        public int get(int idx) {
            int ret = 0;
            for (int i = idx; i > 0; i -= lowbit(i)) {
                ret += data[i];
            }
            return ret;
        }

    }

    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        TreeArray bit = new TreeArray(n + m);
        int[] pos = new int[m+1];
        for (int i = 1; i <= m; i++) {
            pos[i] = n + i;
            bit.update(n + i, 1);
        }
        int[] rets = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = pos[queries[i]];
            bit.update(idx, -1);
            rets[i] = bit.get(idx);
            pos[queries[i]] = n - i;
            bit.update(n - i, 1);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1409 lc = new LeetCode1409();
        int[] arr = {3, 1, 2, 1};
        int m = 5;
        int[] rets = lc.processQueries(arr, m);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
