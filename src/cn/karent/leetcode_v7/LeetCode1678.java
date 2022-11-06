package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 设计Goal解析器
 * @author wan
 * @date 2022.11.06 10:20
 ******************************************/
public class LeetCode1678 {

    public String interpret(String command) {
        char[] chs = command.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'G') {
                sb.append(chs[i]);
            } else {
                int j = i+1;
                while (chs[j] != ')') {
                    j++;
                }
                if (j - i > 1) {
                    sb.append("al");
                } else {
                    sb.append('o');
                }
                i = j;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1678 lc = new LeetCode1678();
//        String command = "G()(al)";
        String command = "G()()()()(al)";
        System.out.println(lc.interpret(command));
    }

}
