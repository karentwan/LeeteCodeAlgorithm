package cn.karent.leetcode_v1;

public class LeetCode896 {

    public boolean isMonotonic(int[] A) {
        boolean flag = true;
        for (int i = 1; i < A.length; i++) {
            if( A[i] < A[i-1]) {
                flag = false;
                break;
            }
        }
        for (int i = 1; i < A.length && !flag; i++) {
            if( A[i] > A[i-1]) {
                return false;
            }
        }
        return true;
    }

}
