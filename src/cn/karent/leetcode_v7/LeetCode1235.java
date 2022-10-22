package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 规划兼职工作
 * @author wan
 * @date 2022.10.22 10:21
 ******************************************/
public class LeetCode1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int size = startTime.length;
        int ret = 0;
        Integer[] ids = new Integer[size];
        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
        int max = 0;
        Arrays.sort(ids, (k1, k2)-> Integer.compare(endTime[k1], endTime[k2]) == 0 ?
                Integer.compare(startTime[k1], startTime[k2]) : Integer.compare(endTime[k1], endTime[k2]));
        for (int i = 0; i < size; i++) {
            int idx = ids[i];
            Map.Entry<Integer, Integer> key = map.floorEntry(startTime[idx]);
            int v = profit[idx];
            if (key != null) {
                v += key.getValue();
            }
            max = Math.max(max, v);
            map.put(endTime[idx], max);
            ret = Math.max(ret, max);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1235 lc = new LeetCode1235();
//        int[] startTime = {1,2,3,3};
//        int[] endTime = {3,4,5,6};
//        int[] profit = {50,10,40,70};
//        int[] startTime = {6,15,7,11,1,3,16,2};
//        int[] endTime = {19,18,19,16,10,8,19,8};
//        int[] profit = {2,9,1,19,5,7,3,19};

//        int[] startTime = {1,2,3,4,6};
//        int[] endTime = {3,5,10,6,9};
//        int[] profit = {6,15,7,11,1,3,16,2};

        int[] startTime = {19,18,19,16,10,8,19,8};
        int[] endTime = {2,9,1,19,5,7,3,19};
        int[] profit = {20,20,100,70,60};
        System.out.println(lc.jobScheduling(startTime, endTime, profit));
    }

}
