package cn.karent.leetcode_v1.weeklycontest303;

/******************************************
 *
 * @author wan
 * @date 2022.07.24 10:30
 ******************************************/
public class LeetCode6124 {

    public char repeatedCharacter(String s) {
        char[] chs = s.toCharArray();
        int[] cache = new int[26];
        for (int i = 0; i < chs.length; i++) {
            int idx = chs[i] - 'a';
            cache[idx]++;
            if (cache[idx] == 2) {
                return chs[i];
            }
        }
        return '\0';
    }
}
