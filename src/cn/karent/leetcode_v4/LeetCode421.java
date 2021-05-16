package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 数组中两个数的最大异或值
 * @author wan
 * @date 2021.05.16
 ********************************************/
public class LeetCode421 {

    public int findMaximumXOR(int[] nums) {
        int ret = 0;
        for (int k = 30; k >= 0; k--) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num >> k);
            }
            int next = ret * 2 + 1;
            ret = next - 1;
            for (Integer item : set) {
                if( set.contains(item ^ next)) {
                    ret = next;
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode421 lc = new LeetCode421();
        int[] arr = {3, 10, 5, 25, 2, 8};
        int ret = lc.findMaximumXOR(arr);
        System.out.println(ret);
    }

}
