package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.07.03
 ***********************************************/
public class LeetCode447 {

    public long pow(int[][] points, int i, int j) {
        return ((long) (Math.pow(points[j][0] - points[i][0], 2) +
                Math.pow(points[j][1] - points[i][1], 2)));
    }

    private void insert(long[] arr, int idx, long v) {
        int i = idx - 1;
        while (i >= 0 && arr[i] > v) {
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = v;
    }

    // 寻找大于v的最大元素
    private int binarySearch(long[] arr, int s, long v) {
        int l = s, r = arr.length-2;
        while (l <= r) {
            int m = l + (r - l)/2;
            if( arr[m] > v) r = m-1;
            else l = m+1;
        }
        return l;
    }

    public int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        int ret = 0;
        long[][] dis = new long[n][n];
        int[] idxes = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long d = pow(points, i, j);
                // 插入i里面, 插入j里面
                insert(dis[i], idxes[i]++, d);
                insert(dis[j], idxes[j]++, d);
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < n - 1) {
                int next = binarySearch(dis[i], j, dis[i][j]);
                int cnt = next - j;
                if (cnt > 1) ret += cnt * (cnt - 1);
                j = next;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode447 lc = new LeetCode447();
        int[][] points = {{0,0},{1,0},{2,0}};
        int ret = lc.numberOfBoomerangs(points);
        System.out.println(ret);
    }

}
