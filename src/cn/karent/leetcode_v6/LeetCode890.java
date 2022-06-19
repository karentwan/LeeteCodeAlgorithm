package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;
import java.util.*;

/******************************************
 * 查找和替换模式
 * @author wan
 * @date 2022.06.12 09:54
 ******************************************/
public class LeetCode890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> rets = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Map<Character, Character> map = new HashMap<>();
            Set<Character> vis = new HashSet<>();
            String word = words[i];
            boolean flag = true;
            for (int j = 0; j < pattern.length(); j++) {
                char c1 = pattern.charAt(j);
                char c2 = word.charAt(j);
                if ((!map.containsKey(c1) && !vis.contains(c2))
                        || (map.containsKey(c1) && map.get(c1) == c2)) {
                    map.put(c1, c2);
                    vis.add(c2);
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                rets.add(word);
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode890 lc = new LeetCode890();
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> rets = lc.findAndReplacePattern(words, pattern);
        LeetCodeUtil.print(rets);
    }

}
