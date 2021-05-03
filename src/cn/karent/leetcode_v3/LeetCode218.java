package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 天际线问题
 * @author wan
 * @date 2021.04.21
 */
public class LeetCode218 {

    private List<List<Integer>> dfs(int[][] building, int l, int r) {
        List<List<Integer>> rets = null;
        if( l == r) {
            rets = new ArrayList<>();
            rets.add(Arrays.asList(building[l][0], building[l][2]));
            rets.add(Arrays.asList(building[l][1], 0));
        } else {
            int m = l + (r - l)/2;
            List<List<Integer>> left = dfs(building, l, m);
            List<List<Integer>> right = dfs(building, m+1, r);
            rets = merge(left, right);
        }
        return rets;
    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        int h1 = 0, h2 = 0, h = 0, c = 0, cx;
        int i = 0, j = 0;
        List<List<Integer>> rets = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            int x = left.get(i).get(0);
            int y = right.get(j).get(0);
            if( x < y) {
                h1 = left.get(i++).get(1);
                cx = x;
            } else if( x > y) {
                h2 = right.get(j++).get(1);
                cx = y;
            } else {
                h1 = left.get(i++).get(1);
                h2 = right.get(j++).get(1);
                cx = x;
            }
            h = Math.max(h1, h2);
            if( h != c) {
                rets.add(Arrays.asList(cx, h));
                c = h;
            }
        }
        while (i < left.size()) rets.add(left.get(i++));
        while (j < right.size()) rets.add(right.get(j++));
        return rets;
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        return dfs(buildings, 0, buildings.length-1);
    }

    public static void main(String[] args) {
        LeetCode218 lc = new LeetCode218();
//        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        int[][] buildings = {{0,2,3},{2,5,3}};
        List<List<Integer>> rets = lc.getSkyline(buildings);
        System.out.println(rets);
    }

}
