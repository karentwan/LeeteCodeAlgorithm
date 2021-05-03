package cn.karent.leetcode_v2;

/**
 * 设计循环队列
 */
public class MyCircularQueue {

    private int[] data = null;

    private int front = 0;
    private int rear = 0;

    private int capacity = 0;

    public MyCircularQueue(int k) {
        capacity = k+1;
        data = new int[capacity];
    }

    public boolean enQueue(int value) {
        if( isFull() ) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deQueue() {
        if( isEmpty() ) {
            return false;
        }
        front = ( front + 1) % capacity;
        return true;
    }

    public int Front() {
        if( isEmpty() ) {
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if( isEmpty() ) {
            return -1;
        }
        int idx = (rear - 1 + capacity) % capacity;
        return data[idx];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

}
