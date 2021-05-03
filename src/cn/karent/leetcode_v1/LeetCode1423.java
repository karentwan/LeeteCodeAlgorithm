package cn.karent.leetcode_v1;

/**
 * 可获得的最大点数
 */
public class LeetCode1423 {
    public int maxScore(int[] cardPoints, int k) {
        int wnd = 0;
        int n = cardPoints.length;
        int i = 0, j = n-1;
        while( k-- > 0 && j >= 0) {
            wnd += cardPoints[j];
            j--;
        }
        int ret = wnd;
        j++;
        while( j < n && i < n) {
            wnd -= cardPoints[j];
            wnd += cardPoints[i];
            j++;
            i++;
            ret = Math.max(ret, wnd);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1423 lc = new LeetCode1423();
        int[] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
//        int[] cardPoints = {2,2,2};
//        int k = 2;
//        int[] cardPoints = {9,7,7,9,7,7,9};
//        int k = 7;
//        int[] cardPoints = {100,40,17,9,73,75};
//        int k = 3;
        int ret = lc.maxScore(cardPoints, k);
        System.out.println(ret);
    }
}
