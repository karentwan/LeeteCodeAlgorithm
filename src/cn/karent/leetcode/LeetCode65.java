package cn.karent.leetcode;

/**
 * 有效数字
 * 使用有效状态机: 一个字符串在一定条件下的规则转移
 * 有效状态机可以解决的问题: 对于给定字符串S, 判断其是否满足条件p, 这里的条件是其是否是一个合法的数字
 */
public class LeetCode65 {

    private int[][] transferTable = {
                                    {2,8,9,1,9},
                                    {2,8,9,9,9},
                                    {2,3,5,9,9},
                                    {4,9,5,9,9},
                                    {4,9,5,9,9},
                                    {7,9,9,6,9},
                                    {7,9,9,9,9},
                                    {7,9,9,9,9},
                                    {4,9,9,9,9},
                                    {9,9,9,9,9}};

    private int get(char ch) {
        if( ch >= '0' && ch <= '9') {
            return 0;
        } else if( ch == '.') {
            return 1;
        } else if( ch == 'e' || ch == 'E') {
            return 2;
        } else if( ch == '+' || ch == '-') {
            return 3;
        }
        return 4;  // 无效字符
    }

    public boolean isNumber(String s) {
        int state = 0;
        s = s.trim();
        for(int i = 0; i < s.length() && state != 9; i++) {
            state = transferTable[state][get(s.charAt(i))];
        }
        return state == 2 || state == 3 || state == 4 || state == 7;
    }

    public static void main(String[] args) {
        LeetCode65 lc = new LeetCode65();
//        String s = "";
//        String[] strs = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] strs = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        for(String s : strs) {
            boolean ret = lc.isNumber(s);
            System.out.println(ret);
        }
    }
}
