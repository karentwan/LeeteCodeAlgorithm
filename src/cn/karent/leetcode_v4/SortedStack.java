package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 栈排序
 * @author wan
 * @date 2021.05.10
 ********************************************/
public class SortedStack {

    private Stack<Integer> st;

    private Stack<Integer> slave;

    public SortedStack() {
        st = new Stack<>();
        slave = new Stack<>();
    }

    public void push(int val) {
        while (!st.isEmpty() && val > st.peek()) {
            slave.push(st.pop());
        }
        st.push(val);
        while (!slave.isEmpty()) {
            st.push(slave.pop());
        }
    }

    public void pop() {
        if( !isEmpty()) st.pop();
    }

    public int peek() {
        if(isEmpty()) return -1;
        return st.peek();
    }

    public boolean isEmpty() {
        return st.isEmpty();
    }

    public static void main(String[] args) {

    }

}
