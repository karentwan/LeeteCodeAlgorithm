package cn.karent.leetcode;

import java.util.*;

/**
 * 超级丑数
 * 丑数：质因数只有primes里面(也就是不能得到除primes之外的其他数)
 */
public class LeetCode313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        que.offer(1);
        seen.add(1l);
        for(int i = 1; i < n; i++) {
            int prime = que.poll();
            for(int j = 0; j < primes.length; j++) {
                long tmp = (long)prime * primes[j];
                if( !seen.contains(tmp) && tmp < Integer.MAX_VALUE) {
                    que.offer((int)tmp);
                    seen.add(tmp);
                }
            }
        }
        return que.poll();
    }

    public static void main(String[] args) {
        LeetCode313 lc = new LeetCode313();
//        int n = 12;
//        int[] primes = {2,7,13,19};
        int n = 100000;
        int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
        int ret = lc.nthSuperUglyNumber(n, primes);
        System.out.println(ret);
    }

}
