package cn.karent.leetcode_v6;

/******************************************
 * 统计不同回文子序列
 * @author wan
 * @date 2022.06.11 11:31
 ******************************************/
public class LeetCode730 {
//
//    public int countPalindromicSubsequences(String s) {
//        int mod = 1000_000_007;
//        char[] chs = s.toCharArray();
//        int n = chs.length;
//        long[][] dp = new long[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = 1;
//        }
//        for (int j = 1; j < n; j++) {
//            for (int i = j - 1; i >= 0; i--) {
//                if (chs[i] == chs[j]) {
//                    int left = i+1, right = j-1;
//                    while (left <= right && chs[left] != chs[i]) left++;
//                    while (left <= right && chs[left] != chs[j]) right--;
//                    if (left > right) {  // 不含s[i]
//                        long tmp = (2 * dp[i + 1][j - 1] + 2) % mod;
//                        if (tmp < 0) {
//                            System.out.println("dp[i+1][j-1]: " + dp[i+1][j-1]);
//                        }
//                        dp[i][j] = tmp;
//                    } else if (left == right) {  // 含有一个s[i]
//                        long tmp = (2 * dp[i + 1][j - 1] + 1) % mod;
//                        if (tmp < 0) {
//                            System.out.println("dp[i + 1][j - 1]: " + dp[i + 1][j - 1]);
//                        }
//                        dp[i][j] = tmp;
//                    } else {  // 含有两个以上的mod
//                        long tmp = (2 * dp[i + 1][j - 1] - dp[left + 1][right - 1]) % mod;
//                        if (tmp < 0) {
//                            System.out.println("dp[i + 1][j - 1]: " + dp[i + 1][j - 1]);
//                        }
//                        dp[i][j] = tmp;
//                    }
//                } else {
//                    long tmp = (dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1]) % mod;
//                    if (tmp < 0) {
//                        System.out.println("dp[i + 1][j]: " + dp[i + 1][j]);
//                    }
//                    dp[i][j] = tmp;
//                }
//            }
//        }
//        return (int) dp[0][n-1];
//    }
//

    public int countPalindromicSubsequences(String s) {
        int mod = 1000_000_007;
        char[] chs = s.toCharArray();
        int n = chs.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (chs[i] == chs[j]) {
                    int left = i+1, right = j-1;
                    while (left <= right && chs[left] != chs[i]) left++;
                    while (left <= right && chs[right] != chs[j]) right--;
                    if (left > right) {
                        dp[i][j] = 2 * dp[i+1][j-1] + 2;
                    } else if (left == right) {
                        dp[i][j] = 2 * dp[i+1][j-1] + 1;
                    } else {
                        dp[i][j] = 2 * dp[i+1][j-1] - dp[left +1][right-1];
                    }
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1];
                }
                //处理超范围结果
                dp[i][j] = (dp[i][j] >= 0) ? dp[i][j] % mod : dp[i][j] + mod;
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        LeetCode730 lc = new LeetCode730();
        String s = "abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba";
//        String s = "bccb";
        System.out.println(lc.countPalindromicSubsequences(s));
    }

}
