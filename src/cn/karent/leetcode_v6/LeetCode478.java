package cn.karent.leetcode_v6;

import java.util.Random;

/******************************************
 * 在圆内随机生成点(拒绝采样)
 * @author wan
 * @date 2022.06.05 10:09
 ******************************************/
public class LeetCode478 {

    Random random;
    double xc, yc, r;

    public LeetCode478(double radius, double x_center, double y_center) {
        random = new Random();
        xc = x_center;
        yc = y_center;
        r = radius;
    }

    public double[] randPoint() {
        while (true) {
            double x = random.nextDouble() * (2 * r) - r;
            double y = random.nextDouble() * (2 * r) - r;
            if (x * x + y * y <= r * r) {
                return new double[]{xc + x, yc + y};
            }
        }
    }

    public static void main(String[] args) {
        LeetCode478 lc = new LeetCode478(1.0,0.0,0.0);
        System.out.println(lc.randPoint());
        System.out.println(lc.randPoint());
        System.out.println(lc.randPoint());
    }

}
