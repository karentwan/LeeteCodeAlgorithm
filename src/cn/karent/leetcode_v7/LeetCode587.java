package cn.karent.leetcode_v7;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-04-23 10:22
 * @description: 安装栅栏
 *******************************************/
public class LeetCode587 {

    int[] subtraction(int[] a, int[] b) {
        return new int[]{a[0] - b[0], a[1] - b[1]};
    }

    double cross(int[] a, int[] b) {
        return a[0] * b[1] - a[1] * b[0];
    }

    double getArea(int[] a, int[] b, int[] c) {
        return cross(subtraction(b, a), subtraction(c, a));
    }

    public int[][] outerTrees(int[][] trees) {
        Arrays.sort(trees, (k1, k2) -> {
            return k1[0] != k2[0] ? k1[0] - k2[0] : k1[1] - k2[1];
        });
        int n = trees.length, tp = 0;
        int[] stk = new int[n + 10];
        boolean[] vis = new boolean[n + 10];
        stk[++tp] = 0;
        for (int i = 1; i < n; i++) {
            int[] c = trees[i];
            while (tp >= 2) {
                int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                if (getArea(a, b, c) < 0) {  // ac构成的面积大于ab构成的面积
                    vis[stk[tp--]] = false;
                } else {
                    break;
                }
            }
            stk[++tp] = i;
            vis[i] = true;
        }
        int size = tp;
        for (int i = n - 1; i >= 0; i--) {
            if (vis[i]) continue;
            int[] c = trees[i];
            while (tp > size) {
                int[] a = trees[stk[tp - 1]], b = trees[stk[tp]];
                if (getArea(a, b, c) < 0) {
                    tp--;
                } else {
                    break;
                }
            }
            stk[++tp] = i;
        }
        int[][] ans = new int[tp - 1][2];
        for (int i = 1; i < tp; i++) ans[i - 1] = trees[stk[i]];
        return ans;
    }

    public static void main(String[] args) {
        LeetCode587 lc = new LeetCode587();

    }

}
