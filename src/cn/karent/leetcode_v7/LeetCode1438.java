package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 *
 * @author wan
 * @date 2022.09.10 10:16
 ******************************************/
public class LeetCode1438 {

    class SegTree {

        private int size;
        private int[] max;

        private int[] min;

        public SegTree(int[] arr) {
            size = arr.length;
            max = new int[size * 4];
            min = new int[size * 4];
            size--;
            build(arr, 0, arr.length-1, 0);
        }

        private void build(int[] arr, int l, int r, int node) {
            if (l == r) {
                max[node] = min[node] = arr[l];
                return;
            }
            int m = l + (r - l) / 2;
            int left = node * 2 + 1;
            build(arr, l, m, left);
            int right = node * 2 + 2;
            build(arr, m+1, r, right);
            max[node] = Math.max(max[left], max[right]);
            min[node] = Math.min(min[left], min[right]);
        }

        private int getMax(int l, int r, int tl, int tr, int node) {
            if (tr < l || r < tl) {
                return Integer.MIN_VALUE;
            }
            if (l <= tl && r >= tr) {
                return max[node];
            }
            int m = tl + (tr - tl) / 2;
            return Math.max(getMax(l, r, tl, m, node * 2 + 1), getMax(l, r, m+1, tr, node*2+2));
        }

        private int getMin(int l, int r, int tl, int tr, int node) {
            if (tr < l || r < tl) {
                return Integer.MAX_VALUE;
            }
            if (l <= tl && r >= tr) {
                return min[node];
            }
            int m = tl + (tr - tl) / 2;
            return Math.min(getMin(l, r, tl, m, node * 2 + 1), getMin(l, r, m+1, tr, node*2+2));
        }

        public int getMin(int l, int r) {
            return getMin(l, r, 0, size, 0);
        }

        public int getMax(int l, int r) {
            return getMax(l, r, 0, size, 0);
        }

    }

    public int longestSubarray1(int[] nums, int limit) {
        SegTree tree = new SegTree(nums);
        int ret = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            int max = tree.getMax(j, i);
            int min = tree.getMin(j, i);
            if (max - min <= limit) {
                ret = Math.max(ret, i - j + 1);
            } else {
                j++;
            }
        }
        return ret;
    }

    class Node implements Comparable<Node> {

        private int idx;
        private int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val == o.val ? idx - o.idx : this.val - o.val;
        }

    }

    public int longestSubarray(int[] nums, int limit) {
        // treeSet和TreeMap通过Comparator和Comparable来确定是否重复
        TreeSet<Node> tree = new TreeSet<>();
        int ret = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            tree.add(new Node(i, nums[i]));
            Node first = tree.first();
            Node last = tree.last();
            if (last.val - first.val <= limit) {
                ret = Math.max(ret, i - j + 1);
            } else {
                tree.remove(new Node(j, nums[j]));
                j++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1438 lc = new LeetCode1438();
//        int[] arr = {8,2,4,7};
//        int limit = 4;
//        int[] arr = {10,1,2,4,7,3};
//        int limit = 5;
        int[] arr = {4,2,2,2,4,4,2,2};
        int limit = 0;
        System.out.println(lc.longestSubarray(arr, limit));
    }

}
