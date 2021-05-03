package cn.karent.leetcode_v1;

import java.util.*;

/**
 * 用栈实现队列
 */
public class MyQueue {

    private Stack<Integer> mainSt = new Stack<>();

    private Stack<Integer> slaveSt = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        mainSt.push(x);
    }

    private void grow() {
        while( !mainSt.isEmpty() ) {
            slaveSt.push(mainSt.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if( empty() ) {
            return -1;
        }
        if( !slaveSt.isEmpty()) {
            return slaveSt.pop();
        }
        grow();
        return slaveSt.pop();
    }

    /** Get the front element. */
    public int peek() {
        if( empty() ) {
            return -1;
        }
        if( !slaveSt.isEmpty() ) {
            return slaveSt.peek();
        }
        grow();
        return slaveSt.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return mainSt.isEmpty() && slaveSt.isEmpty();
    }
}
