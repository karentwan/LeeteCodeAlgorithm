package cn.karent.leetcode_v3.weeklycontest238;

import java.util.*;

/********************************************
 * description: 最高建筑高度
 * @author wan
 * @date 2021.04.25
 ********************************************/
public class Algo5741 {

    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0});
        for (int[] rest : restrictions) {
            list.add(rest);
        }
        Collections.sort(list, (k1, k2) -> k1[0] - k2[0]);
        if( list.get(list.size()-1)[0] != n) {
            list.add(new int[]{n, n-1});
        }
        int length = list.size();
        int prev = 0;
        int prevIdx = 1;
        for (int i = 1; i < length; i++) {
            int idx = list.get(i)[0];
            int h = list.get(i)[1];
            list.get(i)[1] = Math.min(prev + (idx - prevIdx), h);
            prevIdx = idx;
            prev = list.get(i)[1];
        }
        prevIdx = length;
        prev = n-1;
        for (int i = length-2; i >= 0; i--) {
            int idx = list.get(i)[0];
            int h = list.get(i)[1];
            list.get(i)[1] = Math.min(h, prev + (prevIdx - idx));
            prevIdx = idx;
            prev = list.get(i)[1];
        }
        int ret = 0;
        for (int i = 1; i < length; i++) {
            int[] k1 = list.get(i-1);
            int[] k2 = list.get(i);
            ret = Math.max(ret, (k1[1] + k2[1] + k2[0] - k1[0]) / 2);
        }
        return ret;
    }

    public static void main(String[] args) {
        Algo5741 lc = new Algo5741();
//        int n = 5;
//        int[][] restrictions = {{2,1},{4,1}};
//        int n = 6;
//        int[][] restrictions = {};
//        int n = 10;
//        int[][] restrictions = {{5,3},{2,5},{7,4},{10,3}};
        int n = 10;
        int[][] restrictions = {{8,5},{9,0},{6,2},{4,0},{3,2},{10,0},{5,3},{7,3},{2,4}};
        int ret = lc.maxBuilding(n, restrictions);
        System.out.println(ret);
    }

}
