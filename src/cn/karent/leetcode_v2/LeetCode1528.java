package cn.karent.leetcode_v2;

/**
 * 重新排列字符串
 */
public class LeetCode1528 {

    public String restoreString(String s, int[] indices) {
        char[] chs = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chs[indices[i]] = s.charAt(i);
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        LeetCode1528 lc = new LeetCode1528();
//        String s = "codeleet";
//        int[] indices = {4,5,6,7,0,2,1,3};
        String s = "aiohn";
        int[] indices = {3,1,4,2,0};
        String ret = lc.restoreString(s, indices);
        System.out.println(ret);
    }

}
