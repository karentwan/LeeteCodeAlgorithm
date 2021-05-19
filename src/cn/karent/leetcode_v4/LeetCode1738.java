package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 找出第K大的异或坐标值
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int m = matrix.length;
        if( m == 0) return 0;
        int n = matrix[0].length;
        int[][] tmps = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                tmps[i][j] = tmps[i-1][j] ^ tmps[i][j-1] ^ tmps[i-1][j-1] ^ matrix[i-1][j-1];
                if( que.size() < k) que.offer(tmps[i][j]);
                else if( !que.isEmpty() && tmps[i][j] > que.peek()) {
                    que.offer(tmps[i][j]);
                    que.poll();
                }
            }
        }
        return que.isEmpty() ? 0 : que.peek();
    }

    public static void main(String[] args) {
        LeetCode1738 lc = new LeetCode1738();
//        int[][] matrix = {{5,2},{1,6}};
//        int k = 1;
        int[][] matrix = {{5,2},{1,6}};
        int k = 3;
        int ret = lc.kthLargestValue(matrix, k);
        System.out.println(ret);
    }

}
