package cn.karent.leetcode_v1;

import cn.karent.util.*;

/**
 * 反转链表 二
 */
public class LeetCode92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 1;
        ListNode phead = new ListNode();
        ListNode phead0 = new ListNode();
        phead0.next = head;
        ListNode p = head, prev = phead0;
        while( cnt < left && p != null) {
            prev = p;
            p = p.next;
            cnt++;
        }
        ListNode tail = p;
        ListNode tmp = null;
        while (cnt <= right && p != null) {
            tmp = p.next;
            p.next = phead.next;
            phead.next = p;
            p = tmp;
            cnt++;
        }
        prev.next = phead.next;
        tail.next = tmp;
        return phead0.next;
    }

    public static void main(String[] args) {
        LeetCode92 lc = new LeetCode92();
//        Integer[] arr = {1,2,3,4,5};
//        int m = 1;
//        int n = 5;
        Integer[] arr = {3,5};
        int m = 2;
        int n = 2;
//        Integer[] arr = {1,2,3};
//        int m = 3;
//        int n = 3;
        ListNode head = LeetCodeUtil.arr2ListNode(arr);
        ListNode ret = lc.reverseBetween(head, m, n);
        LeetCodeUtil.traverseList(ret);
    }

}
