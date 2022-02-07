package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-02-07 12:58
 * @description: 最长快乐字符串
 *******************************************/
public class LeetCode1405 {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((k1, k2) -> k2[1] - k1[1]);
        if (a > 0) pq.add(new int[]{0, a});
        if (b > 0) pq.add(new int[]{1, b});
        if (c > 0) pq.add(new int[]{2, c});
        for (;!pq.isEmpty();) {
            int[] poll = pq.poll();
            int n = sb.length();
            if (n >= 2 && sb.charAt(n-1) - 'a' == poll[0] && sb.charAt(n-2) - 'a' == poll[0]) {
                // 次数取次多的元素
                if (pq.isEmpty()) break;
                int[] tmp = pq.poll();
                sb.append((char)(tmp[0] + 'a'));
                if (--tmp[1] != 0) pq.add(tmp);
                pq.add(poll);
            } else {
                sb.append((char)(poll[0] + 'a'));
                if (--poll[1] != 0) pq.add(poll);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1405 lc = new LeetCode1405();
        int a = 1;
        int b = 1;
        int c = 7;
        System.out.println(lc.longestDiverseString(a, b, c));
    }

}
