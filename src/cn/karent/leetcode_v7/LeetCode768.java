package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 最多能完成排序的块 二
 * @author wan
 * @date 2022.08.13 08:37
 ******************************************/
public class LeetCode768 {

    private void add(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key) && map.get(key) == -1) {
            map.remove(key);
        } else {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
    }

    private void del(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key) && map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.getOrDefault(key, 0)-1);
        }
    }

    public int maxChunksToSorted1(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ret = 0;
        int[] sortedArr = new int[arr.length];
        System.arraycopy(arr, 0, sortedArr, 0, arr.length);
        Arrays.sort(sortedArr);
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            add(cnt, x);
            del(cnt, y);
            if (cnt.isEmpty()) ret++;
        }
        return ret;
    }

    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int item : arr) {
            if (st.isEmpty() || item >= st.peekLast()) {
                st.offerLast(item);
            } else {
                int t = st.pollLast();
                while (!st.isEmpty() && item < st.peekLast()) {
                    st.pollLast();
                }
                st.offerLast(t);
            }
        }
        return st.size();
    }

    public int maxChunksToSorted3(int[] arr) {
        int[] right = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for (int i = arr.length-1; i >= 0; i--) {
            min = Math.min(min, arr[i]);
            right[i] = min;
        }
        int ret = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i+1 == arr.length || max <= right[i+1]) ret++;
        }
        return ret;
    }

    public int maxChunksToSorted4(int[] arr) {
        if (arr.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < arr.length; i++) pq.offer(arr[i]);
        int ret = 0;
        int max = arr[0];
        if (max <= pq.peek()) {
            ret++;
        }
        for (int i = 1; i < arr.length; i++) {
            // 前面最大的小于后面最小的
            int t = pq.poll();
            // 这种解法有问题, pq.poll()
            if (pq.isEmpty() || max <= pq.peek()) {
                ret++;
                max = Math.max(max, arr[i]);
                pq.offer(t);
                pq.remove((Integer) arr[i]);
            } else {
                max = Math.max(max, arr[i]);
                pq.offer(t);
                pq.remove((Integer) arr[i]);
            }
        }
        return Math.max(ret, 1);
    }

    public static void main(String[] args) {
        LeetCode768 lc = new LeetCode768();
//        int[] arr = {5,4,3,2,1};
//        int[] arr = {0,0,1,1,1};
        int[] arr = {1,0,1,3,2};
//        int[] arr = {2, 1, 3, 4, 4};
//        int[] arr = {2,0,1};
//        int[] arr = {4,2,2,1,1};
        System.out.println(lc.maxChunksToSorted(arr));
    }

}
