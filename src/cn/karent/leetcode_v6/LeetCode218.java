package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/***********************************************
 * description: 天际线问题
 * @author wan
 * @date 2021.07.13
 ***********************************************/
public class LeetCode218 {

    private List<List<Integer>> dfs(int[][] buildings, int l, int r) {
        List<List<Integer>> rets = new ArrayList<>();
        if( l == r) {
            rets.add(Arrays.asList(buildings[l][0], buildings[l][2]));
            rets.add(Arrays.asList(buildings[l][1], 0));
            return rets;
        }
        int m = l + (r - l)/2;
        List<List<Integer>> left = dfs(buildings, l, m);
        List<List<Integer>> right = dfs(buildings, m+1, r);
        // 这个应该是扫描线法, 从左到右扫, 然后依次合并
        // 扫描线类似于一种合并算法, 将多种一样的东西合并成
        // 一个大的东西, 所以可以使用分治+扫描线
        int i = 0, j = 0;
        int last = 0, h1 = 0, h2 = 0;
        while (i < left.size() && j < right.size()) {
            List<Integer> t1 = left.get(i);
            List<Integer> t2 = right.get(j);
            int x = 0, y = 0;
            if( t1.get(0) < t2.get(0)) {
                x = t1.get(0);
                h1 = t1.get(1);
                i++;
                // Integer对象不要使用==号, 否则数值一样也会失败
                // 真要比较可以使用Integer.compare(t1.get(0), t2.get(0))来比较
                // 或者先将Integer转成int再来比较
            } else if( t1.get(0) == t2.get(0)) {
                x = t1.get(0);
                h1 = t1.get(1);
                h2 = t2.get(1);
                i++;
                j++;
            } else {
                x = t2.get(0);
                h2 = t2.get(1);
                j++;
            }
            y = Math.max(h1, h2);
            if( y != last) {
                if( l == 0 && r == length-1) {
                    System.out.println("h1:" + h1 + "\th2:" + h2 + "\tx:" + x + "\ty:" + y + "\tlast:" + last);
                }
                rets.add(Arrays.asList(x, y));
                last = y;
            }
        }
//       int h1 = 0, h2 = 0, c = 0, cx = 0, h = 0;
//        while (i < left.size() && j < right.size()) {
//            int x = left.get(i).get(0);
//            int y = right.get(j).get(0);
//            if( x < y) {
//                h1 = left.get(i++).get(1);
//                cx = x;
//            } else if( x > y) {
//                h2 = right.get(j++).get(1);
//                cx = y;
//            } else {
//                h1 = left.get(i++).get(1);
//                h2 = right.get(j++).get(1);
//                cx = x;
//            }
//            h = Math.max(h1, h2);
//            if( h != c) {
//                rets.add(Arrays.asList(cx, h));
//                c = h;
//            }
//        }
        while (i < left.size()) {
            rets.add(left.get(i++));
        }
        while (j < right.size()) {
            rets.add(right.get(j++));
        }
        return rets;
    }

    int length;

    public List<List<Integer>> getSkyline(int[][] buildings) {
        length = buildings.length;
        List<List<Integer>> rets = dfs(buildings, 0, buildings.length - 1);;
        return rets;
    }

    private List<List<Integer>> merge(List<List<Integer>> left, List<List<Integer>> right) {
        int i = 0, j = 0;
        int h1 = 0, h2 = 0, cx = 0, h = 0, c = 0;
        List<List<Integer>> rets = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            List<Integer> t1 = left.get(i);
            List<Integer> t2 = right.get(j);
            if( t1.get(0) < t2.get(0)) {
                cx = t1.get(0);
                h1 = t1.get(1);
                i++;
            } else if( Integer.compare(t1.get(0), t2.get(0)) == 0) {
                cx = t1.get(0);
                h1 = t1.get(1);
                h2 = t2.get(1);
                i++;
                j++;
            } else {
                cx = t2.get(0);
                h2 = t2.get(1);
                j++;
            }
            h = Math.max(h1, h2);
            if( h != c) {
                rets.add(Arrays.asList(cx, h));
                c = h;
            }
        }
        while (i < left.size()) {
            rets.add(left.get(i++));
        }
        while (j < right.size()) {
            rets.add(right.get(j++));
        }
        return rets;
    }

    private List<List<Integer>> merge2(List<List<Integer>> left, List<List<Integer>> right) {
        int i = 0, j = 0;
        int h1 = 0, h2 = 0, cx = 0, h = 0, c = 0;
        List<List<Integer>> rets = new ArrayList<>();
        while (i < left.size() && j < right.size()) {
            List<Integer> t1 = left.get(i);
            List<Integer> t2 = right.get(j);
            int x1 = t1.get(0);
            int x2 = t2.get(0);
            if( x1 < x2) {
                cx = x1;
                h1 = t1.get(1);
                i++;
            } else if( x1 == x2) {
                cx = x1;
                h1 = t1.get(1);
                h2 = t2.get(1);
                i++;
                j++;
            } else {
                cx = x2;
                h2 = t2.get(1);
                j++;
            }
            h = Math.max(h1, h2);
            if( h != c) {
                rets.add(Arrays.asList(cx, h));
                c = h;
            }
        }
        while (i < left.size()) {
            rets.add(left.get(i++));
        }
        while (j < right.size()) {
            rets.add(right.get(j++));
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode218 lc = new LeetCode218();
//        int[][] building = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
//        int[][] building = {{0,2,3},{2,5,3}};
//        int[][] building = {{1,2,1},{1,2,2},{1,2,3}};
//        List<List<Integer>> rets = lc.getSkyline(building);
//        System.out.println(rets);
        Integer[][] left = {{1, 10000}, {1000, 11001}, {3000, 13001}, {5000, 15001}, {10001, 0}};
        Integer[][] right = {{5001, 5000}, {7000, 17001}, {9000, 19001}, {10001, 0}};
        List<List<Integer>> t1 = LeetCodeUtil.arr2list(left);
        List<List<Integer>> t2 = LeetCodeUtil.arr2list(right);
        System.out.println(lc.merge(t1, t2));
        System.out.println(lc.merge2(t1, t2));

    }

}
