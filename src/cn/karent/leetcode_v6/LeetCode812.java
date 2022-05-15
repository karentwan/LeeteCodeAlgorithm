package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-05-15 10:13
 * @description: 最大三角形面积
 *******************************************/
public class LeetCode812 {

    public double largestTriangleArea(int[][] points) {
        double ret = 0.0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    ret = Math.max(ret, triangleArea(points[i][0], points[i][1],
                            points[j][0], points[j][1], points[k][0], points[k][1]) );
                }
            }
        }
        return ret;
    }

    private double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs(x1 * y2 + x2*y3 + x3*y1 - x1 *y3 - x2 *y1 - x3*y2);
    }

    public static void main(String[] args) {
        LeetCode812 lc = new LeetCode812();

    }

}
