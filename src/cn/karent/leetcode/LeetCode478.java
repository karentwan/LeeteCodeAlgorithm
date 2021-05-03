package cn.karent.leetcode;

/**
 * 在圆内随机生成点
 */
public class LeetCode478 {

    private double radius = 0;

    private double x_center = 0;

    private double y_center = 0;

    public LeetCode478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {

        while( true ) {
            double x = Math.random() * radius * 2 + x_center - radius;
            double y = Math.random() * radius * 2 + y_center - radius;
            if( Math.sqrt(Math.pow(x-x_center, 2) + Math.pow(y-y_center, 2)) <= radius) {
                return new double[]{x, y};
            }
        }
    }

    public static void main(String[] args) {
        LeetCode478 lc = new LeetCode478(1,0,0);
        double[] ret = lc.randPoint();
        System.out.println("(" + ret[0] + ", " + ret[1] + ")");

    }
}
