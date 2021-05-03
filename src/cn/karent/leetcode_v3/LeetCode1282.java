package cn.karent.leetcode_v3;

import java.util.*;

/**
 * 用户分组
 * @author wan
 * @date 2021.04.16
 */
public class LeetCode1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> rets = new ArrayList<>();
        int n = groupSizes.length;
        if( n == 0) return rets;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (k1, k2) -> groupSizes[k1] - groupSizes[k2]);
        int i = 0;
        while ( i < n) {
            int idx = indices[i];
            int gn = groupSizes[idx];
            List<Integer> ret = new ArrayList<>();
            rets.add(ret);
            ret.add(idx);
            int j = i+1;
            gn--;
            while (j < n && gn > 0) {
                ret.add(indices[j]);
                j++;
                gn--;
            }
            i = j;
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1282 lc = new LeetCode1282();
//        int[] groupSize = {3,3,3,3,3,1,3};
        int[] groupSize = {2,1,3,3,3,2};
        List<List<Integer>> rets = lc.groupThePeople(groupSize);
        System.out.println(rets);
    }

}
