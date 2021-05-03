package cn.karent.leetcode;

/**
 * 祖玛游戏
 */
public class LeetCode488 {

    private char[] colors = {'R', 'Y', 'B', 'G', 'W'};

    private int[] map = new int[26];

    private int ret = Integer.MAX_VALUE;

    private StringBuilder eliminate(StringBuilder sb) {
        boolean flag = true;
        int i = 0, j = 0;
        while( flag ) {
            i = 0;
            flag = false;
            while( i < sb.length() ) {
                j = i+1;
                while( j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                if( j - i >= 3) {
                    sb.delete(i, j);
                    flag = true;
                }
                i++;
            }
        }
        return sb;
    }

    private void dfs(StringBuilder sb, int step) {
        if( step >= ret) {
            return;
        }
        if( sb.length() == 0) {
            ret = Math.min(ret, step);
            return;
        }
        int i = 0, j = 0;
        while( i < sb.length() ) {
            j = i;
            while( j + 1 < sb.length() && sb.charAt(j) == sb.charAt(j+1)) {
                j++;
            }
            char ch = sb.charAt(i);
            if( i == j && map[ch - 'A'] >= 2) { // 只有一个相同的颜色
                StringBuilder tmp = new StringBuilder(sb);
                tmp.insert(i, ch + "" + ch);
                map[ch - 'A'] -= 2;
                dfs(eliminate(tmp), step+2);
                map[ch - 'A'] += 2;
            } else if( i+1 == j ){  // 有两个相同的颜色
                if( map[ch - 'A'] >= 1) {
                    StringBuilder tmp = new StringBuilder(sb);
                    tmp.insert(i, ch);
                    map[ch - 'A'] -= 1;
                    dfs(eliminate(tmp), step+1);
                    map[ch - 'A'] += 1;
                }
                for(char color : colors) {
                    if( color == ch) {
                        continue;
                    }
                    if( map[color - 'A'] >= 1) {
                        StringBuilder tmp = new StringBuilder(sb);
                        tmp.insert(i+1, color);
                        map[color - 'A'] -= 1;
                        dfs(eliminate(tmp), step+1);
                        map[color - 'A'] += 1;
                    }
                }
            }
            i = j+1;
        }
    }

    public int findMinStep(String board, String hand) {
        for(int i = 0; i < hand.length(); i++) {
            map[hand.charAt(i) - 'A']++;
        }
        dfs(new StringBuilder(board), 0);
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }

    public static void main(String[] args) {
        LeetCode488 lc = new LeetCode488();
        String board = "WRRBBW";
        String hand = "RB";
//        String board = "WWRRBBWW";
//        String hand = "WRBRW";
        int ret = lc.findMinStep(board, hand);
        System.out.println(ret);
    }
}
