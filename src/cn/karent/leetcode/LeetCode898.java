package cn.karent.leetcode;

import java.util.*;

/**
 * 子数组按位或操作
 */
public class LeetCode898 {

    public int subarrayBitwiseORs1(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        cur.add(0);
        for(int x : arr) {
            Set<Integer> cur1 = new HashSet<>();
            for(int y : cur) {
                cur1.add(x | y);
            }
            cur1.add(x);
            ans.addAll(cur1);
            cur = cur1;
        }
        return ans.size();
    }

    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            ans.add(arr[i]);
            for(int j = i-1; j >= 0; j--) {
                if( (arr[i] | arr[j]) == arr[j] ) {
                    break;
                }
                arr[j] |= arr[i];
                ans.add(arr[j]);
            }
        }
        return ans.size();
    }

    public static void main(String[] args) {
        LeetCode898 lc = new LeetCode898();
        int[] nums = {1,1,2};
        int ans = lc.subarrayBitwiseORs(nums);
        System.out.println(ans);
    }

}
