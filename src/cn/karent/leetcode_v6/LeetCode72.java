package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022-05-14 12:02
 * @description: 编辑距离
 *      dp: 根据操作就可以将大问题拆分为子问题,
 *      如果子问题具有重叠性质并且无后效性就是dp
 *  所有的操作都拆分为三种操作：
 *      1) 给A加一个字符
 *      2) 给B加一个字符
 *      3) 给A替换一个字符
 *******************************************/
public class LeetCode72 {

    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        // 初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int leftDown = dp[i-1][j-1];
                if (word1.charAt(i-1) != word2.charAt(j-1)) {
                    leftDown++;
                }
                dp[i][j] = Math.min(left, Math.min(down, leftDown));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LeetCode72 lc = new LeetCode72();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(lc.minDistance(word1, word2));
    }

}
