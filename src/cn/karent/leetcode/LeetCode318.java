package cn.karent.leetcode;

/**
 * 最大单词长度乘积
 */
public class LeetCode318 {

    public int maxProduct(String[] words) {
        int[] mask = new int[words.length];
        int[] len = new int[words.length];
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            int m = 0;
            for(int j = 0; j < word.length(); j++) {
                m |= 1 << (word.charAt(j) - 'a');
            }
            mask[i] = m;
            len[i] = word.length();
        }
        int ret = 0;
        for(int i = 0; i < words.length; i++) {
            for(int j = i+1; j < words.length; j++) {
                if( (mask[i] & mask[j]) == 0) {
                    ret = Math.max(ret, len[i] * len[j]);
                }
            }
        }
        return ret;
    }
}
