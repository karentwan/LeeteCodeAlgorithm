package cn.karent.leetcode;

import java.util.*;

/**
 * 数据流中的第k大的元素
 */
public class KthLargest {

//    private int part(int[] nums, int l, int r) {
//        int tmp = nums[l];
//        while( l < r) {
//            while( l < r && nums[r] <= tmp) {
//                r--;
//            }
//            nums[l] = nums[r];
//            while( l < r && nums[l] > tmp) {
//                l++;
//            }
//            nums[r] = nums[l];
//        }
//        nums[l] = tmp;
//        return l;
//    }
//
//    private void quickSort(int[] nums, int l, int r) {
//        if( l >= r) {
//            return;
//        }
//        int mid = part(nums, l, r);
//        quickSort(nums, l, mid-1);
//        quickSort(nums, mid+1, r);
//    }
//
//    private List<Integer> list = new ArrayList<>();
//
//    private int k = 0;
//
//    public KthLargest(int k, int[] nums) {
//        this.k = k;
//        quickSort(nums, 0, nums.length-1);
//        for(int i : nums) {
//            list.add(i);
//        }
//    }
//
//    private void adjust() {
//        if( list.size() <= 1) {
//            return;
//        }
//        int tmp = list.get(list.size()-1);
//        int i = list.size()-2;
//        while( i >= 0 && tmp > list.get(i)) {
//            list.set(i+1, list.get(i));
//            i--;
//        }
//        list.set(i+1, tmp);
//    }
//
//    public int add(int val) {
//        list.add(val);
//        adjust();
//        return list.get(k-1);
//    }

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    private int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        int i = 0;
        while( minHeap.size() < k && i < nums.length) {
            minHeap.offer(nums[i++]);
        }
        while( i < nums.length) {
            if( nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
            i++;
        }
    }

    public int add(int val) {
        if( minHeap.size() < k) {
            minHeap.offer(val);
        } else if( minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {4,5,8,2};
        int k = 3;
        KthLargest kl = new KthLargest(k, nums);
//        kl.quickSort(nums, 0, nums.length-1);
//        for(int i : nums) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
        int ret = kl.add(3);
        System.out.println(ret);
        ret = kl.add(5);
        System.out.println(ret);
        ret = kl.add(10);
        System.out.println(ret);
        ret = kl.add(9);
        System.out.println(ret);
        ret = kl.add(4);
        System.out.println(ret);
    }

}
