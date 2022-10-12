package cn.karent.leetcode_v7;

import cn.karent.util.LeetCodeUtil;
import cn.karent.util.ListNode;
import java.util.*;
import java.util.stream.Collectors;

/******************************************
 * 链表组件
 * @author wan
 * @date 2022.10.12 08:30
 ******************************************/
public class LeetCode817 {

    public int numComponents(ListNode head, int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int cnt = 0, ret = 0;
        ListNode p = head;
        while (p != null) {
            if (set.contains(p.val)) {
                cnt++;
            } else {
                if (cnt > 0) {
                    ret++;
                }
                cnt = 0;
            }
            p = p.next;
        }
        if (cnt > 0) ret++;
        return ret;
    }

    public static void main(String[] args) {
        LeetCode817 lc = new LeetCode817();
//        Integer[] arr = {0,1,2,3};
//        int[] nums = {0,1,3};
        Integer[] arr = {0,1,2,3,4};
        int[] nums = {0,3,1,4};
        ListNode head = LeetCodeUtil.arr2ListNode(arr);
        System.out.println(lc.numComponents(head, nums));
    }

}
