package cn.karent.leetcode_v2;

import java.util.*;
import cn.karent.util.*;


/**
 * 最大的团队表现值
 * @author wan
 * @date 2021.04.03
 */
public class LeetCode1383 {

    class Staff {
        private int e;
        private int s;

        public Staff(int e, int s) {
            this.e = e;
            this.s = s;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Staff> staffs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            staffs.add(new Staff(efficiency[i], speed[i]));
        }
        Collections.sort(staffs, (k1, k2) -> k2.e - k1.e);
        PriorityQueue<Staff> pq = new PriorityQueue<>((k1, k2) -> k1.s - k2.s);
        long ret = 0;
        long sum = 0;
        int MOD = ((int) (1e9 + 7));
        for (int i = 0; i < n; i++) {
            Staff staff = staffs.get(i);
            int min = staff.e;
            sum += staff.s;
            ret = Math.max(ret, min * sum);
            pq.offer(staff);
            if( pq.size() == k) {
                sum -= pq.poll().s;
            }
        }
        return ((int) (ret % MOD));
    }

    public static void main(String[] args) {
        int n = 6;
        int[] speed = {2,10,3,1,5,8};
        int[] efficiancy = {5,4,3,9,7,2};
        int k = 2;
        LeetCode1383 lc = new LeetCode1383();
        int ret = lc.maxPerformance(n, speed, efficiancy, k);
        System.out.println(ret);
    }

}
