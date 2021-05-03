package cn.karent.leetcode_v2;

import cn.karent.util.*;

/**
 * 删除排序链表中的重复元素 二
 */
public class LeetCode82 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode phead = new ListNode(Integer.MIN_VALUE, head);
        ListNode p1 = phead;
        ListNode p2 = head;
        int prev = Integer.MAX_VALUE;
        while (p2 != null) {
            if( p1.val != p2.val &&
                    ( prev != p2.val &&
                            ( p2.next == null || p2.next.val != p2.val))) {
                p1.next = p2;
                p1 = p1.next;
            }
            prev = p2.val;
            p2  = p2.next;
        }
        p1.next = null;
        return phead.next;
    }

    public static void main(String[] args) {
        LeetCode82 lc = new LeetCode82();
        Integer[] arr = {1,2,3,3,3,4,4,5};
//        Integer[] arr = {1,1,1,2,3,3};
//        Integer[] arr = {1,1};
        ListNode head = LeetCodeUtil.arr2ListNode(arr);
        LeetCodeUtil.traverseList(head);
        ListNode ret = lc.deleteDuplicates(head);
        LeetCodeUtil.traverseList(ret);
    }

}
