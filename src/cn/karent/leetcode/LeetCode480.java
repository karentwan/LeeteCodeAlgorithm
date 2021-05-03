package cn.karent.leetcode;

import java.util.*;

/**
 * 滑动窗口中位数
 */
public class LeetCode480 {

    PriorityQueue<Integer> min = new PriorityQueue<>((Integer item1, Integer item2) -> {
        return Integer.compare(item2, item1);
    });
    PriorityQueue<Integer> max = new PriorityQueue<>();
    int k = 0;
    void add(int item) {
        if( max.isEmpty() || min.isEmpty()) {
            max.offer(item);
        } else if( item >= max.peek()) {
            max.offer(item);
        } else {
            min.offer(item);
        }
    }

    double get() {
        if( max.isEmpty()) {
            return 0;
        }
        while( max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
        while(min.size() > max.size()) {
            max.offer(min.poll());
        }
        double ret = 0;
        if( (k & 1) == 1) {  // 奇数
           ret = max.peek();
        } else {
            ret = max.peek() * 0.5 + min.peek() * 0.5;
        }
       return ret;
    }

    void remove(Integer item) {
        if( max.contains(item)) {
            max.remove(item);
        } else if( min.contains(item)) {
            min.remove(item);
        }
        while( max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
        while( min.size() > max.size()) {
            max.offer(min.poll());
        }
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        double[] rets = new double[nums.length - k + 1];
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            add(nums[i]);
            if( i >= k-1) {
                rets[idx++] = get();
                remove(nums[i-k+1]);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode480 lc = new LeetCode480();
        int k = 3;
        int[] nums = {1,3,-1,-3,5,3,6,7};
        double[] rets = lc.medianSlidingWindow(nums, k);
        for(double ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }
}
