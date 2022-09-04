package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 统计最高分的节点数目
 * @author wan
 * @date 2022.09.04 18:33
 ******************************************/
public class LeetCode2049 {

    private long ret = 0;

    private long score = 0;

    private long maxScore(List[] edges, int idx) {
        long tmp = 1, cnt = 0;
        List<Integer> edge = edges[idx];
        for (int i = 0; i < edge.size(); i++) {
            long t = maxScore(edges, edge.get(i));
            tmp *= t;
            cnt += t;
        }
        tmp *= Math.max(edges.length - cnt - 1, 1);
        if (tmp == score) {
            ret++;
        } else if (tmp > score) {
            ret = 1;
            score = tmp;
        }
        return cnt + 1;
    }

    public int countHighestScoreNodes(int[] parents) {
        List[] edges = new List[parents.length];
        for (int i = 0; i < parents.length; i++) {
            edges[i] = new ArrayList();
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] > -1) {
                edges[parents[i]].add(i);
            }
        }
        maxScore(edges, 0);
        return (int) ret;

    }

    public static void main(String[] args) {
        LeetCode2049 lc = new LeetCode2049();
        int[] parents = {-1,2,0,2,0};
        System.out.println(lc.countHighestScoreNodes(parents));
    }

}
