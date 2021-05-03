package cn.karent.leetcode_v1;

import cn.karent.util.*;
import java.util.*;

/**
 * 叶值的最小代价生成树
 */
public class LeetCode1130 {

    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ret = 0;
        st.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while( a > st.peek()) {
                ret += st.pop() * Math.min(st.peek(), a);
            }
            st.push(a);
        }
        while( st.size() >= 2) {
            ret += ( st.pop() * st.peek());
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1130 lc = new LeetCode1130();
        int[] arr = {6,2,4};
        int ret = lc.mctFromLeafValues(arr);
        System.out.println(ret);
    }

}
