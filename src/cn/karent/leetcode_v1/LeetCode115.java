package cn.karent.leetcode_v1;


/**
 * 不同的序列
 */
public class LeetCode115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i && j <= t.length() ; j++) {
                dp[i][j] = dp[i-1][j];
                if( j > 0 && s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        LeetCode115 lc = new LeetCode115();
        String s = "rabbbit";
        String t = "rabbit";
//        String s = "babgbag";
//        String t = "bag";
        int ret = lc.numDistinct(s, t);
        System.out.println(ret);
    }

}
