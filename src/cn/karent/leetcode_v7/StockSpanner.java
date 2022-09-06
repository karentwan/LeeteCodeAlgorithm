package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 股票价格跨度
 * @author wan
 * @date 2022.09.06 23:21
 ******************************************/
public class StockSpanner {

    private Deque<int[]> st = new ArrayDeque<>();
    private int cnt = 0;
    public StockSpanner() {
        st.offerLast(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        while (!st.isEmpty() && price >= st.peekLast()[1]) {
            st.pollLast();
        }
        int ret = cnt - st.peekLast()[0];
        st.offerLast(new int[]{cnt, price});
        cnt++;
        return ret;
    }

    public static void main(String[] args) {
        StockSpanner lc = new StockSpanner();
        System.out.println(lc.next(100));
        System.out.println(lc.next(80));
        System.out.println(lc.next(60));
        System.out.println(lc.next(70));
        System.out.println(lc.next(60));
        System.out.println(lc.next(75));
        System.out.println(lc.next(85));
    }

}
