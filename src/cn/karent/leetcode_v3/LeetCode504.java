package cn.karent.leetcode_v3;

import java.util.*;

/********************************************
 * description: 七进制数
 * @author wan
 * @date 2021.04.26
 ********************************************/
public class LeetCode504 {

    public String convertToBase7(int num) {
        if(num == 0) return "0";
        Stack<Integer> st = new Stack<>();
        int sign = num < 0 ? -1 : 1;
        while (num != 0) {
            st.push((num % 7) * sign);
            num /= 7;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sign == -1 ? "-" + sb.toString() : sb.toString();
    }

    public static void main(String[] args) {
        LeetCode504 lc = new LeetCode504();
//        int n = 100;
        int n = -7;
//        int n = -8;
        String ret = lc.convertToBase7(n);
        System.out.println(ret);
    }

}
