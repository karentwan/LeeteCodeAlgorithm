package cn.karent.leetcode_v6.weeklycontest302;

import java.util.Arrays;

/******************************************
 * 裁剪数字后查询第k小的数字
 * @author wan
 * @date 2022.07.17 10:48
 ******************************************/
public class LeetCode6121 {

    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        Integer[] indices = new Integer[nums.length];
        int[] rets = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            for (int j = 0; j < indices.length; j++) {
                indices[j] = j;
            }
            Arrays.sort(indices, (k1, k2) -> {
                String s1 = nums[k1];
                String s2 = nums[k2];
                int length = s1.length();
                String key1 = s1.substring(Math.max(length - query[1], 0), length);
                String key2 = s2.substring(Math.max(length - query[1], 0), length);
                int c = key1.compareTo(key2);
                if (c == 0) {
                    return k1 - k2;
                }
                return c;
            });
            rets[i] = indices[query[0]-1];
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode6121 lc = new LeetCode6121();
//        String[] nums = {"102", "473", "251", "814"};
//        int[][] queries = {{1,1},{2,3},{4,2},{1,2}};
        String[] nums = {"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"};
        int[][] queries = {{9,4},{6,1},{3,8},{12,9},{11,4},{4,9},{2,7},{10,3},
                {13,1},{13,1},{6,1},{5,10}};
        int[] rets = lc.smallestTrimmedNumbers(nums, queries);
        for (int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }

}
