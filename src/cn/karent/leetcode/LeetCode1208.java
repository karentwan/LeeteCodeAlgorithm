package cn.karent.leetcode;

/**
 * 尽可能使字符串相等
 */
public class LeetCode1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int ret = 0;
        int i = 0;
        int cost = 0;
        for(int j = 0; j < s.length() && j < t.length(); j++) {
            cost += Math.abs(s.charAt(j) - t.charAt(j));
            if( cost <= maxCost) {
                ret = Math.max(ret, j - i + 1);
            } else {
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1208 lc = new LeetCode1208();
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int ret = lc.equalSubstring(s, t, maxCost);
        System.out.println(ret);
    }
}
