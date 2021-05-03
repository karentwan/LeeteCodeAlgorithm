package cn.karent.leetcode;

/**
 * 按奇偶排序数组 二
 */
public class LeetCode922 {

    public int[] sortArrayByParityII1(int[] A) {
        int i = 0, j = A.length-1;
        while( i < j ) {
            while( i < j && A[i] % 2 == 0) {
                i++;
            }
            while( i < j && A[j] % 2 == 1) {
                j--;
            }
            int t = A[i];
            A[i] = A[j];
            A[j] = t;
        }
        i = 0;
        j = A.length-1;
        while( i < j) {
            while( i < j && A[i] % 2 == i % 2) {
                i++;
            }
            while( i < j && A[j] % 2 == j % 2) {
                j--;
            }
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
        return A;
    }

    // 一次遍历, 分别用两个指针维护奇偶指针
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1;
        while( i < A.length && j < A.length) {
            while( i < A.length && A[i] % 2 == 0) {
                i += 2;
            }
            while( j < A.length && A[j] % 2 == 1) {
                j += 2;
            }
            if( i < A.length && j < A.length) {
                int t = A[i];
                A[i] = A[j];
                A[j] = t;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        LeetCode922 lc = new LeetCode922();
//        int[] A = {4,2,5,7};
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        int[] ret = lc.sortArrayByParityII(A);
        print(ret);
    }

    private static void print(int[] ret) {
        for(int i : ret) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
