package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: 直线上最多的点数
 * @author wan
 * @date 2021.06.24
 ***********************************************/
public class LeetCode149 {

    private int gcd_(int a, int b) {
        return b == 0 ? a : gcd_(b, a % b);
    }

    private int gcd(int a, int b) {
        if( a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return gcd_(a, b);
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if( n <= 2) return n;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if( x == 0) y = 1;
                if( y == 0) x = 1;
                else {
                    if( y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int g = gcd(Math.abs(x), Math.abs(y));
                    x /= g;
                    y /= g;
                }
                int key = x * 20001 + y;
                int value = map.getOrDefault(key, 0) + 1;
                map.put(key, value);
            }
            for (Integer key : map.keySet()) {
                int v = map.get(key);
                ret = Math.max(ret, v + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode149 lc = new LeetCode149();
//        int[][] points = {{1,1}, {2,2}, {3,3}, {4,4}, {5,5}};
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int ret = lc.maxPoints(points);
        System.out.println(ret);
    }

}
