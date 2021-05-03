package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 旋转链表
 */
public class LeetCode61 {

    private int getLength(ListNode p) {
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int cnt = 0;
        ListNode p1 = head, p2 = head;
        int length = getLength(head);
        if( length == 0 || (k = k % length) == 0) {
            return head;
        }
        while ( cnt < k && p2 != null) {
            p2 = p2.next;
            cnt++;
        }
        ListNode prev = null;
        ListNode tail = null;
        while (p2 != null) {
            prev = p1;
            p1 = p1.next;
            tail = p2;
            p2 = p2.next;
        }
        prev.next = null;
        tail.next = head;
        return p1;
    }

    public static void main(String[] args) {
        LeetCode61 lc = new LeetCode61();
        Integer[] arr = {0,1,2};
        int k = 8;
        ListNode head = LeetCodeUtil.arr2ListNode(arr);
        LeetCodeUtil.traverseList(head);
        ListNode ret = lc.rotateRight(head, k);
        LeetCodeUtil.traverseList(ret);
    }

}
