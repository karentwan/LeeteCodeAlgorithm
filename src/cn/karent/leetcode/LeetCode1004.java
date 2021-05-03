package cn.karent.leetcode;

/**
 * 最大连续1的个数 二
 */
public class LeetCode1004 {

    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0;
        int ret = 0, wnd = 0;  // wnd 窗口内0的个数
        while( j < A.length ) {
            wnd = A[j++] == 0 ? wnd+1 : wnd;
            if( wnd <= K) {
                ret = Math.max(ret, j - i);
            } else {
                wnd = A[i++] == 0 ? wnd-1 : wnd;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1004 lc = new LeetCode1004();
//        int[] A = {1,1,1,0,0,0,1,1,1,1,0};
//        int k = 2;
        int[] A = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        int ret = lc.longestOnes(A, k);
        System.out.println(ret);
    }

}
