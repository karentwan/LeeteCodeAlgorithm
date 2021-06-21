package cn.karent.leetcode_v5;

import java.util.*;
import cn.karent.util.*;

/***********************************************
 * description: 链表随机节点
 * @author wan
 * @date 2021.06.21
 ***********************************************/
public class LeetCode382 {

    private ListNode head;

    private Random random;

    public LeetCode382(ListNode head) {
        this.head = head;
        random = new Random();
    }

    private int nextInt(int n) {
        int ret = (int) (Math.random() * n);
        return ret;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int val = 0;
        int cnt = 0;
        for (ListNode p = head; p != null; p = p.next, cnt++) {
            if( random.nextInt(cnt + 1) == cnt) val = p.val;
        }
        return val;
    }

    public static void main(String[] args) {
//        t1();
        LeetCode382 lc = new LeetCode382(null);
        System.out.println(lc.nextInt(1));
    }

    private static void t1() {
        double[] data1 = new double[10];
        double[] data2 = new double[10];
        LeetCode382 lc = new LeetCode382(null);
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            data1[lc.nextInt(10)]++;
            data2[random.nextInt(10)]++;
        }
        for (int i = 0; i < 10; i++) {
            data1[i] /= 100000;
            data2[i] /= 100000;
            System.out.println("n:" + i + "\tp1:" + data1[i] + "\tp2:" + data2[i]);
        }
    }

}
