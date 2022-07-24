package cn.karent.leetcode_v1.weeklycontest303;

/******************************************
 * 相等行列对
 * @author wan
 * @date 2022.07.24 10:32
 ******************************************/
public class LeetCode6125 {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        String[] rows = new String[n];
        String[] cols = new String[n];
        // 计算行
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.delete(0, sb.length());
            for (int j = 0; j < n; j++) {
                sb.append(grid[i][j]).append(":");
            }
            rows[i] = sb.toString();
        }
        // 计算列
        for (int i = 0; i < n; i++) {
            sb.delete(0, sb.length());
            for (int j = 0; j < n; j++) {
                sb.append(grid[j][i]).append(":");
            }
            cols[i] = sb.toString();
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rows[i].equals(cols[j])) {
                    ret++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6125 lc = new LeetCode6125();
        int[][] grid = {{11, 1}, {1, 11}};
        System.out.println(lc.equalPairs(grid));
    }


}
