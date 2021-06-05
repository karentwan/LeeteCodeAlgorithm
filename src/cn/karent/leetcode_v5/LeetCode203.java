package cn.karent.leetcode_v5;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 移除链表元素
 * @author wan
 * @date 2021.06.05
 ********************************************/
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode phead = new ListNode();
        ListNode p = phead, p1 = head;
        while (p1 != null) {
            if( p1.val != val) {
                p.next = p1;
                p = p.next;
            }
            p1 = p1.next;
        }
        p.next = null;
        return phead.next;
    }

    public static void main(String[] args) {

    }

}
