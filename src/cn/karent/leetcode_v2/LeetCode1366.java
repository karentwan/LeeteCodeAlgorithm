package cn.karent.leetcode_v2;

import java.util.*;

/**
 * 通过投票对团队排名
 */
public class LeetCode1366 {


    public String rankTeams(String[] votes) {
        if( votes.length == 0) {
            return "";
        }
        int teamN = votes[0].length();
        int[][] ballots = new int[teamN][teamN];
        Map<Character, Integer> map = new HashMap<>();
        Character[] chs = new Character[teamN];
        for (int i = 0; i < votes[0].length(); i++) {
            map.put(votes[0].charAt(i), i);
            chs[i] = votes[0].charAt(i);
        }
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                int idx = map.get(vote.charAt(i));
                ballots[idx][i]++;
            }
        }
        Arrays.sort(chs, (k1, k2) -> {
            int t1 = map.get(k1);
            int t2 = map.get(k2);
            int[] b1 = ballots[t1];
            int[] b2 = ballots[t2];
            int i = 0;
            while (i < b1.length && b1[i] == b2[i]) {
                i++;
            }
            return i >= b1.length ? k1 - k2 : b2[i] - b1[i];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < teamN; i++) {
            sb.append(chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1366 lc = new LeetCode1366();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
//        String[] votes = {"WXYZ","XYZW"};
//        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        String ret = lc.rankTeams(votes);
        System.out.println(ret);
    }

}
