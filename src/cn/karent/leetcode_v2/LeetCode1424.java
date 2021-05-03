package cn.karent.leetcode_v2;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/**
 * 对角线遍历 二
 */
public class LeetCode1424 {
/*
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int m = nums.size();
        if( m == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        int maxLength = 0;
        for (int i = 0; i < m; i++) {
            int x = 0, y = i;
            while (y >= 0) {
                List<Integer> tmp = nums.get(y);
                maxLength = Math.max(maxLength, tmp.size());
                if( x < tmp.size()) {
                    list.add(tmp.get(x));
                }
                x++;
                y--;
            }
        }
        for (int i = 1; i < maxLength; i++) {
            int x = i, y = m-1;
            while ( x < maxLength && y >= 0) {
                List<Integer> tmp = nums.get(y);
                if( x < tmp.size()) {
                    list.add(tmp.get(x));
                }
                x++;
                y--;
            }
        }
        int[] rets = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rets[i] = list.get(i);
        }
        return rets;
    }

   */

   class Node {
       private int i;
       private int j;
       private int val;

       public Node(int i, int j, int val) {
           this.i = i;
           this.j = j;
           this.val = val;
       }
   }

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Node> tmps = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> tmp = nums.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                tmps.add(new Node(i, j, tmp.get(j)));
            }
        }
        Collections.sort(tmps, (k1, k2) -> {
            int t = k1.i + k1.j;
            int t2 = k2.i + k2.j;
            return t == t2 ? k1.j - k2.j : t - t2;
        });
        int[] rets = new int[tmps.size()];
        for (int i = 0; i < tmps.size(); i++) {
            rets[i] = tmps.get(i).val;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1424 lc = new LeetCode1424();
        Integer[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
//        Integer[][] nums = {{1,2,3,4,5,6}};
//        Integer[][] nums = {{1},{2},{3},{4}};
        List<List<Integer>> arr = LeetCodeUtil.arr2list(nums);
        int[] rets = lc.findDiagonalOrder(arr);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
