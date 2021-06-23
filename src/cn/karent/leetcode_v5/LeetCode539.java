package cn.karent.leetcode_v5;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/***********************************************
 * description: 最小时间差
 * @author wan
 * @date 2021.06.23
 ***********************************************/
public class LeetCode539 {

    private int get(String s) {
        String[] strs = s.split(":");
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int t = a * 60 + b;
        return t;
    }

    public int findMinDifference(List<String> timePoints) {
        TreeSet<Integer> ts = new TreeSet<>();
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < timePoints.size(); i++) {
            int t = get(timePoints.get(i));
            int t1 = 1440 + t;
            Integer a = ts.floor(t);
            Integer b = ts.ceiling(t);
            if( a != null ) ret = Math.min(ret, t - a);
            if( b != null ) ret = Math.min(ret, b - t);
            ts.add(t);
            a = ts.floor(t1);
            b = ts.ceiling(t1);
            if( a != null) ret = Math.min(ret, t1 - a);
            if( b != null) ret = Math.min(ret, b - t1);
            ts.add(t1);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode539 lc = new LeetCode539();
        String[] arr = {"23:59", "00:00"};
        List<String> list = LeetCodeUtil.arr2list(arr);
        int ret = lc.findMinDifference(list);
        System.out.println(ret);
    }

}
