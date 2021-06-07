package cn.karent.leetcode_v5;

import java.util.*;

/********************************************
 * description: 需要教语言的最少人数
 * @author wan
 * @date 2021.06.07
 ********************************************/
public class LeetCode1733 {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Map<Integer, Set<Integer>> langPeoples = new HashMap<>();  // 每种语言会的人数
        int m = languages.length;
        for (int i = 0; i < m; i++) {
            int[] lgs = languages[i];
            for (int lg : lgs) {
                langPeoples.computeIfAbsent(lg, k -> new HashSet<Integer>()).add(i+1);
            }
        }
        boolean[] canSpeaks = new boolean[friendships.length];
        for (int i = 0; i < friendships.length; i++) {
            int a = friendships[i][0], b = friendships[i][1];
            for (Integer key : langPeoples.keySet()) {
                Set<Integer> set = langPeoples.get(key);
                if( set.contains(a) && set.contains(b)) {
                    canSpeaks[i] = true;
                    break;
                }
            }
        }
        int ret = m-1;
        for (Integer key : langPeoples.keySet()) {
            Set<Integer> set = langPeoples.get(key);
            int cnt = 0;
            for (int i = 0; i < friendships.length; i++) {
                if( canSpeaks[i]) continue;
                int a = friendships[i][0], b = friendships[i][1];
                if( !set.contains(a)) {
                    cnt++;
                    set.add(a);
                }
                if( !set.contains(b)) {
                    cnt++;
                    set.add(b);
                }
            }
            ret = Math.min(ret, cnt);
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1733 lc = new LeetCode1733();
        int n = 2;
        int[][] lang = {{1},{2},{1,2}};
        int[][] friends = {{1,2},{1,3},{2,3}};
        int ret = lc.minimumTeachings(n, lang, friends);
        System.out.println(ret);
    }

}
