package cn.karent.leetcode_v6;

import cn.karent.util.ListNode;
import java.util.Random;

/**
 * 链表随机节点
 */
public class LeetCode382 {


    private Random random = new Random();

    private ListNode head;

    public LeetCode382(ListNode head) {
        this.head = head;
    }

    // 蓄水池抽样
    public int getRandom() {
        ListNode p = head;
        int ret = 0;
        for (int i = 0; p != null; i++, p = p.next) {
            int idx = random.nextInt(i + 1);
            if (idx == i) {
                ret = p.val;
            }
        }
        return ret;
    }

}
