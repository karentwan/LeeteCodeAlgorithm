package cn.karent.leetcode_v6;

/*******************************************
 * @author wan
 * @date: 2022.05.28 09:47
 * @description: 删除最外层的括号
 *******************************************/
public class LeetCode1021 {

    public String removeOuterParentheses(String s) {
        char[] chs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 0, pre = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == '(') {
                pre = cnt++;
            } else {
                pre = cnt--;
            }
            if (pre != 0 && cnt != 0) {
                sb.append(chs[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1021 lc = new LeetCode1021();
//        String s = "(()())(())";
        String s = "(()())(())(()(()))";
        System.out.println(lc.removeOuterParentheses(s));
    }

}
