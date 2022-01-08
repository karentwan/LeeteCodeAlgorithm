package cn.karent.leetcode_v6;

public class LeetCode390 {

    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) {  // 当k为偶数表示从左到右删
                a1 = a1 + step;
            } else {  // 从右到左删
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

    public static void main(String[] args) {
        LeetCode390 lc = new LeetCode390();
        int n = 9;
        System.out.println(lc.lastRemaining(n));
    }

}
