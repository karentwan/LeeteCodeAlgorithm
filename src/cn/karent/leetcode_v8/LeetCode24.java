package cn.karent.leetcode_v8;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.ListNode;

import java.util.*;

/**
 * 两两交换链表中的节点
 * @author wan
 * @date 2023.08.06 09:41
 */
public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode p1, p2, p = head, dummy = new ListNode(), pre = dummy;
        dummy.next = head;
        while (p != null) {
            p1 = p;
            p = p.next;
            p2 = p;
            if (p != null) p = p.next;
            if (p2 == null) {
                pre.next = p1;
            } else {
                pre.next = p2;
                p2.next = p1;
                p1.next = null;
            }
            pre = p1;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        LeetCode24 lc = new LeetCode24();
        Integer[] arr = {1,2,3};
        ListNode head = LeetCodeUtil.arr2ListNode(arr);
        LeetCodeUtil.traverseList(head);
        ListNode newHead = lc.swapPairs(head);
        LeetCodeUtil.traverseList(newHead);
    }

}
