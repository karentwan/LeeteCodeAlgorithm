package cn.karent.leetcode_v1.weeklycontest304;

import java.util.*;

/******************************************
 * 分组的最大数量
 * @author wan
 * @date 2022.07.31 10:33
 ******************************************/
public class LeetCode6133 {

    public int maximumGroups(int[] grades) {
        int ret = 0, cnt = 1;
        for (int i = 0; i < grades.length; ) {
            if (i + cnt <= grades.length) {
                ret++;
                i += cnt++;
            } else {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode6133 lc = new LeetCode6133();
        int[] grades = {10, 6, 12, 7, 3, 5};
        System.out.println(lc.maximumGroups(grades));
    }

}
