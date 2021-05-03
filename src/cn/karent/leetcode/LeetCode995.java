package cn.karent.leetcode;

import java.util.*;

/**
 * k连续位的最小翻转次数
 */
public class LeetCode995 {

    // brute force, TLE(time limit exceed)
    public int minKBitFlips1(int[] A, int K) {
        int i = 0, j = 0, tmp = 0, cnt = 0;
        boolean flag = true;
        while( i < A.length) {
            while( i < A.length && A[i] == 1) {
                i++;
            }
            j = i;
            tmp = i+K;
            if (tmp > A.length) {
                flag = !(j < A.length);
                break;
            }
            while( j < A.length && j < i + K) {
                A[j] = A[j] == 0 ? 1 : 0;
                if( A[j] == 0 && j < tmp) {
                    tmp = j;
                }
                j++;
            }
            cnt++;
            i = tmp;
        }
        return flag ? cnt : -1;
    }

    public int minKBitFlips(int[] A, int K) {
        LinkedList<Integer> que = new LinkedList<>();
        int cnt = 0;
        for(int i = 0; i < A.length; i++) {
            if( !que.isEmpty() && que.peek() <= i - K) {
                que.poll();
            }
            if( que.size() % 2 == A[i]) {
                que.offer(i);
                if( i + K > A.length) {
                    return -1;
                }
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        LeetCode995 lc = new LeetCode995();
//        int[] A = {0,1,0};
//        int k = 1;
//        int[] A = {1,1,0};
//        int k = 2;
        int[] A = {0,0,0,1,0,1,1,0};
        int k = 3;
        int ret = lc.minKBitFlips(A, k);
        System.out.println(ret);
    }

}
