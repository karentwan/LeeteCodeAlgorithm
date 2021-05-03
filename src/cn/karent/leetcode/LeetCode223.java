package cn.karent.leetcode;

/**
 * 矩形面积
 */
public class LeetCode223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ret = (D - B) * (C - A) + (H - F) * (G - E);
        if( B >= H || F >= D || C <= E || G <= A) {
            return ret;
        }
        int up = Math.min(H, D);
        int down = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        return ret - (up - down) * (right - left);
    }

    public static void main(String[] args) {
        LeetCode223 lc = new LeetCode223();
        int A = -3;
        int B = 0;
        int C = 3;
        int D = 4;
        int E = 0;
        int F = -1;
        int G = 9;
        int H = 2;
        int ret = lc.computeArea(A, B, C, D, E, F, G, H);
        System.out.println(ret);
    }

}
