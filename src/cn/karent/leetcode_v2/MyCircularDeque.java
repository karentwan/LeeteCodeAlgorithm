package cn.karent.leetcode_v2;

/**
 * 设计循环双端队列
 */
public class MyCircularDeque {

    private int capacity = 0;

    private int[] data = null;

    private int front;

    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k+1;
        data = new int[capacity];
        front = rear = 0;
    }

    private int add(int idx) {
        return (idx + 1) % capacity;
    }

    private int subtract(int idx) {
        return (idx - 1 + capacity) % capacity;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if( isFull()) {
            return false;
        }
        int idx = subtract(front);
        data[idx] = value;
        front = idx;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if( isFull() ) {
            return false;
        }
        data[rear] = value;
        rear = add(rear);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if( isEmpty() ) {
            return false;
        }
        front = add(front);
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if( isEmpty()) {
            return false;
        }
        rear = subtract(rear);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if( isEmpty()) {
            return -1;
        }
        return data[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if( isEmpty()) {
            return -1;
        }
        int idx = subtract(rear);
        return data[idx];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return rear == front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public static void main(String[] args) {
        MyCircularDeque que = new MyCircularDeque(3);
        que.insertLast(1);			        // 返回 true
        que.insertLast(2);			        // 返回 true
        que.insertFront(3);			        // 返回 true
        que.insertFront(4);			        // 已经满了，返回 false
        que.getRear();  				// 返回 2
        que.isFull();				        // 返回 true
        que.deleteLast();			        // 返回 true
        que.insertFront(4);			        // 返回 true
        que.getFront();				// 返回 4

    }

}
