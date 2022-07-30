package cn.karent.leetcode_v1;

import java.util.*;

/******************************************
 * 按公因数计算最大组件大小
 * @author wan
 * @date 2022.07.30 10:59
 ******************************************/
public class LeetCode952 {

    class DSU {

        int[] parent;

        int[] cnt;

        int ans = 1;

        public DSU(int size) {
            parent = new int[size];
            cnt = new int[size];
            Arrays.fill(cnt, 1);
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            return x == parent[x] ? x : find(parent[x]);
        }

        /**
         * 这个地方如果使用 parent[p1] = p2; 则会超时....
         * @param x1
         * @param x2
         */
        public void union(int x1, int x2) {
            int p1 = find(x1);
            int p2 = find(x2);
            if (p1 != p2) {
                parent[p2] = p1;
                cnt[p1] += cnt[p2];
                ans = Math.max(cnt[p1], ans);
            }
        }

        public int max() {
            return ans;
        }

    }

    public int largestComponentSize(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        DSU dsu = new DSU(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    map.computeIfAbsent(j, k->new ArrayList<>()).add(i);
                    while (num % j == 0) num /= j;
                }
            }
            if (num > 1) map.computeIfAbsent(num, k->new ArrayList<>()).add(i);
        }
        // 可以用并查集求最大连通分量
        for (Map.Entry<Integer, List<Integer>> kv : map.entrySet()) {
            List<Integer> list = kv.getValue();
            for (int i = 1; i < list.size(); i++) {
                dsu.union(list.get(0), list.get(i));
            }
        }
        return dsu.max();
    }

    public static void main(String[] args) {
        LeetCode952 lc = new LeetCode952();
//        int[] nums = {4,6,15,35};
//        int[] nums = {20,50,9,63};
        int[] nums = {2,3,6,7,4,12,21,39};
        System.out.println(lc.largestComponentSize(nums));
    }

}
