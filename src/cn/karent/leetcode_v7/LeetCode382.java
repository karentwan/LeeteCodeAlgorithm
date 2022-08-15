package cn.karent.leetcode_v7;

import java.util.*;
import cn.karent.util.*;

/******************************************
 * 链表随机节点
 * @author wan
 * @date 2022.08.15 21:09
 ******************************************/
public class LeetCode382 {

    private ListNode head;

    private Random random;

    public LeetCode382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    public int getRandom() {
        int ret = -1;
        ListNode p = head;
        for (int i = 1; p != null; i++, p = p.next) {
            if (random.nextInt(i) == 0) {
                ret = p.val;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        ListNode head = LeetCodeUtil.arr2ListNode(arr);
        LeetCode382 lc = new LeetCode382(head);
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
    }

}
