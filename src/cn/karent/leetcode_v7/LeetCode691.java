package cn.karent.leetcode_v7;

/*******************************************
 * @author wan
 * @date: 2022.05.22 10:15
 * @description: 贴纸拼词
 *******************************************/
public class LeetCode691 {

    public int minStickers(String[] stickers, String target) {
        int[] memo = new int[1 << target.length()];  // 记忆化
        int left = (1 << target.length()) - 1;  // 剩余多少个元素
        long ret = dfs(stickers, left, memo, target);
        return ret == Integer.MAX_VALUE ? -1 : (int) ret;
    }

    private long dfs(String[] stickers, int left, int[] memo, String target) {
        if (memo[left] > 0) {
            return memo[left];
        }
        if (left == 0) return 0;
        long ret = Integer.MAX_VALUE;
        for (int i = 0; i < stickers.length; i++) {
            // 统计sticker的所有字符
            int[] chs = new int[26];
            for (int j = 0; j < stickers[i].length(); j++) {
                chs[stickers[i].charAt(j) - 'a']++;
            }
            int tmp = left;
            boolean flag = false;
            for (int j = 0; j < target.length(); j++) {
                if (((tmp >> j) & 1) != 0 && chs[target.charAt(j) - 'a'] > 0) {
                    tmp ^= (1 << j);  // 将第j位置0, 其他位保持不变
                    chs[target.charAt(j) - 'a'] -= 1;
                    flag = true;
                }
            }
            if (flag) {
                ret = Math.min(ret, 1 + dfs(stickers, tmp, memo, target));
            }
        }
        memo[left] = (int) ret;
        return memo[left];
    }


    public static void main(String[] args) {
        LeetCode691 lc = new LeetCode691();
//        String[] stickers = {"with","example","science"};
//        String target = "thehat";
        String[] stickers = {"notice","possible"};
        String target = "basicbasic";
        System.out.println(lc.minStickers(stickers, target));
    }

}
