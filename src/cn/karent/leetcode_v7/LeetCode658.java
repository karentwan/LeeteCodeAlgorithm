package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 找到k个最接近的元素
 * @author wan
 * @date 2022.08.25 08:30
 ******************************************/
public class LeetCode658 {

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        // 使用大顶堆保存最接近的多个数字
        PriorityQueue<int[]> pq = new PriorityQueue<>((k1, k2) -> k2[0] - k1[0]);
        for (int i : arr) {
            if (pq.size() < k) {
                pq.offer(new int[]{Math.abs(x - i), i});
            } else if (pq.peek()[0] > Math.abs(x - i)) {
                pq.poll();
                pq.offer(new int[]{Math.abs(x - i), i});
            }
        }
        List<Integer> rets = new ArrayList<>();
        while (!pq.isEmpty()) {
            rets.add(pq.poll()[1]);
        }
        Collections.sort(rets);
        return rets;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length-1;
        while ( l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > x) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        int i = l-1, j = l;
        while (j - i - 1 < k) {
            if ( i >= 0 && j < arr.length) {
                if (Math.abs(x - arr[i]) > Math.abs(x - arr[j])) {
                    j++;
                } else {
                    i--;
                }
            } else if (i < 0) {
                j++;
            } else {
                i--;
            }
        }
        List<Integer> rets = new ArrayList<>();
        for (int p =i+1; p < j; p++) {
            rets.add(arr[p]);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode658 lc = new LeetCode658();
//        int[] arr = {1,2,3,4,5};
//        int k = 4;
//        int x = 3;
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = -1;
        List<Integer> rets = lc.findClosestElements(arr, k, x);
        LeetCodeUtil.print(rets);
    }

}
