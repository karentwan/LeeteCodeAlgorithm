package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 带限制的子序列和
 * @author wan
 * @date 2022.09.14 20:10
 ******************************************/
public class LeetCode1425 {

    class Node implements Comparable<Node> {
        private int idx;
        private int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return val == o.val ? o.idx - idx : o.val - val;
        }

    }

    public int constrainedSubsetSum1(int[] nums, int k) {
        TreeSet<Node> set = new TreeSet<>();
        set.add(new Node(0, 0));
        int ret = Integer.MIN_VALUE, wnd = 0;
        int[] tmps = new int[nums.length+1];
        for (int i = 1, j = 0; i <= nums.length; i++) {
            wnd = Math.max(nums[i-1], set.first().val + nums[i-1]);
            tmps[i] = wnd;
            set.add(new Node(i, wnd));
            if (i - j >= k) {
                // TreeSet.remove()方法是根据compareTo方法比较是否相等并删除, 时间复杂度为O(logn)
                // PriorityQueue.remove()是根据equals方法比较是否相等并删除, 时间复杂度为O(n)
                set.remove(new Node(j, tmps[j]));
                j++;
            }
            ret = Math.max(ret, wnd);
        }
        return ret;
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<int[]> st = new ArrayDeque<>();
        int ret = Integer.MIN_VALUE, wnd = 0;
        st.offerLast(new int[]{-1, 0});
        for (int i = 0; i < nums.length; i++) {
            wnd = Math.max(nums[i], st.peekFirst()[1] + nums[i]);
            ret = Math.max(ret, wnd);
            // 单调栈入队
            while (!st.isEmpty() && wnd >= st.peekLast()[1]) {
                st.pollLast();
            }
            st.offerLast(new int[]{i, wnd});
            // 去掉超出范围的数据
            if (st.peekFirst()[0] <= i - k) {
                st.pollFirst();
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1425 lc = new LeetCode1425();
//        int[] nums = {10, 2, -10, 5, 20};
//        int k = 2;
//        int[] nums = {-1,-2,-3};
//        int k = 1;
//        int[] nums = {10,-2,-10,-5,20};
//        int k = 2;
        int[] nums ={-8269,3217,-4023,-4138,-683,6455,-3621,9242,4015,-3790};
        int k = 1;
        System.out.println(lc.constrainedSubsetSum(nums, k));
    }

}
