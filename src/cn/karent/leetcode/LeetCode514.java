package cn.karent.leetcode;

import java.util.*;

/**
 * 自由之路
 */
public class LeetCode514 {

    private Map<String, Integer> map = new HashMap<>();

    private Map<Character, List<Integer>> indices = new HashMap<>();

    private int dfs(String ring, int rIdx, String key, int kIdx) {
        if( kIdx >= key.length()) {
            return 0;
        }
        String mKey = rIdx + "" + kIdx;
        if( map.containsKey(mKey) ) {
            return map.get(mKey);
        }
        char ch = key.charAt(kIdx);
        int ret = Integer.MAX_VALUE;
        for(int idx : indices.get(ch)) {
            int min1 = Math.abs(idx - rIdx);
            int min2 = ring.length() - min1;
            int tmp = Math.min(min1, min2) + 1 + dfs(ring, idx, key, kIdx+1);
            ret = Math.min(ret, tmp);
        }
        map.put(mKey, ret);
        return ret;
    }

    public int findRotateSteps(String ring, String key) {
        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            for(int j = 0; j < ring.length(); j++) {
                if( ring.charAt(j) == ch) {
                    indices.computeIfAbsent(ch, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int ret = dfs(ring, 0, key, 0);
        return ret;
    }

    public static void main(String[] args) {
        LeetCode514 lc = new LeetCode514();
        String ring = "godding";
        String key = "gd";
        int ret = lc.findRotateSteps(ring, key);
        System.out.println(ret);
    }

}
