package cn.karent.leetcode;

/**
 * 重塑矩阵
 */
public class LeetCode566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        if( m == 0) {
            return nums;
        }
        int n = nums[0].length;
        if( m * n != r * c) {
            return nums;
        }
        int[][] rets = new int[r][c];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int tmp = i * n + j;
                int nx = tmp / c;
                int ny = tmp % c;
                rets[nx][ny] = nums[i][j];
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode566 lc = new LeetCode566();
        int[][] nums = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        int[][] rets = lc.matrixReshape(nums, r, c);
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(rets[i][j] + " ");
            }
            System.out.println();
        }
    }

}
