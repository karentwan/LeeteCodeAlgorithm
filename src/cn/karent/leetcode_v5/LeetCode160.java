package cn.karent.leetcode_v5;

import java.util.*;
import cn.karent.util.*;

/********************************************
 * description: 相交链表
 * @author wan
 * @date 2021.06.04
 ********************************************/
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        if( p1 == null || p2 == null) return null;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if( p1 == null) {
                p1 = headB;
                headB = null;
            }
            if( p2 == null) {
                p2 = headA;
                headA = null;
            }
        }
        return p1;
    }

    public static void main(String[] args) {

    }

}
