package cn.karent.leetcode;

/**
 * 替换后的最长重复字符
 */
public class LeetCode424 {

    /**
     * 滑动窗口右移的情况是窗口内字符数量最多的字符已经不能满足条件了, 这题的关键不是判断左右字符
     * 当窗口移动到最后, 窗口的长度就是最长重复字符的长度
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int[] cache = new int[26];
        int i = 0;
        int maxCnt = 0;
        for(int j = 0; j < s.length(); j++) {
            int idx = s.charAt(j) - 'A';
            cache[idx]++;
            maxCnt = Math.max(maxCnt, cache[idx]);
            if( j - i + 1 - maxCnt > k) {
                idx = s.charAt(i) - 'A';
                cache[idx]--;
                i++;
            }
        }
        return s.length() - i;
    }

    public static void main(String[] args) {
        LeetCode424 lc = new LeetCode424();
//        String s = "ABAB";
//        int k = 2;
//        String s = "AABABBA";
//        int k = 1;
        String s = "BAAAB";
        int k = 2;
        int ret = lc.characterReplacement(s, k);
        System.out.println(ret);
    }
}
