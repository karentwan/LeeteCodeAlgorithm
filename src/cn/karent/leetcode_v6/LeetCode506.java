package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/***********************************************
 * description: 
 * @author wan
 * @date 2021.07.02
 ***********************************************/
public class LeetCode506 {

    public String[] findRelativeRanks(int[] score) {
        String[] rets = new String[score.length];
        PriorityQueue<int[]> que = new PriorityQueue<>((k1, k2)->k2[0] - k1[0]);
        for (int i = 0; i < score.length; i++) {
            que.offer(new int[]{score[i], i});
        }
        if( !que.isEmpty()) {
            rets[que.poll()[1]] = "Gold Medal";
        }
        if( !que.isEmpty()) {
            rets[que.poll()[1]] = "Silver Medal";
        }
        if( !que.isEmpty()) {
            rets[que.poll()[1]] = "Bronze Medal";
        }
        for (int i = 4; !que.isEmpty(); i++) {
            rets[que.poll()[1]] = i + "";
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode506 lc = new LeetCode506();
        int[] arr = {5,4,3,2,1};
        String[] rets = lc.findRelativeRanks(arr);
        LeetCodeUtil.print(rets);
    }

}
