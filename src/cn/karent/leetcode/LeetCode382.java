package cn.karent.leetcode;

import cn.karent.util.*;

/**
 * 链表随机节点
 */
public class LeetCode382 {

    private ListNode head = null;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LeetCode382(ListNode head) {
        this.head = head;
    }

    private int nextInt(int n) {
        return (int)(Math.random() * n);
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int cnt = 1;
        int val = 0;
        ListNode p = head;
        while( p != null) {
            if(nextInt(cnt) == cnt) {
                val = p.val;
            }
            cnt++;
            p = p.next;
        }
        return val;
    }
}
