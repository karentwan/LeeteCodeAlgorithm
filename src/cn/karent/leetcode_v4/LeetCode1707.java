package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 与数组中元素的最大异或值
 * @author wan
 * @date 2021.05.23
 ********************************************/
public class LeetCode1707 {

    class TrieNode {
        private TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }

        public TrieNode insert(int bit) {
            if( children[bit] == null) {
                children[bit] = new TrieNode();
            }
            return children[bit];
        }

        public TrieNode get(int bit) {
            return children[bit];
        }

    }

    class Trie {
        private TrieNode root;
        private int L;

        public Trie() {
            root = new TrieNode();
            L = 30;
        }

        public void insert(int val) {
            TrieNode p = root;
            for (int i = L-1; i >= 0; i--) {
                int bit = (val >> i) & 1;
                p = p.insert(bit);
            }
        }

        public int xor(int x) {
            TrieNode p = root;
            int ret = 0;
            for (int i = L-1; i >= 0; i--) {
                int bit = (x >> i) & 1;
                // 任何数与1异或都是取反, 与0异或就是它本身
                if( (p.get(bit ^ 1)) != null) {
                    ret |= 1 << i;
                    p = p.get(bit ^ 1);
                } else p = p.get(bit);
            }
            return ret;
        }

    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = queries.length;
        int[] rets = new int[n];
        Arrays.sort(nums);
        int[][] tmps = new int[n][3];
        for (int i = 0; i < n; i++) {
            tmps[i][0] = queries[i][0];
            tmps[i][1] = queries[i][1];
            tmps[i][2] = i;
        }
        Arrays.sort(tmps, (k1, k2)-> k1[1] - k2[1]);
        int idx = 0;
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            int x = tmps[i][0];
            int m = tmps[i][1];
            int index = tmps[i][2];
            while (idx < nums.length && nums[idx] <= m) {
                trie.insert(nums[idx]);
                idx++;
            }
            if( idx == 0) rets[index] = -1;
            else rets[index] = trie.xor(x);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1707 lc = new LeetCode1707();
//        int[] arr = {0, 1, 2, 3, 4};
//        int[][] queries = {{3,1},{1,3},{5,6}};
        int[] arr = {5,2,4,6,6,3};
        int[][] queries = {{12,4},{8,1},{6,3}};
        int[] rets = lc.maximizeXor(arr, queries);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
    }

}
