package cn.karent.leetcode_v4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/********************************************
 * description: 多线程之打印0和奇偶数
 * @author wan
 * @date 2021.05.18
 ********************************************/
public class ZeroEvenOdd {

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    private ReentrantLock lock = new ReentrantLock();

    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    private int cnt = 1;

    private int current = 0;

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(; cnt <= n;) {
            lock.lock();
            try {
                while( current != 0) {
                    even.signal();
                    odd.signal();
                    zero.await();
                }
                // 虽然进来时cnt<=n, 但是休眠的过程中 cnt 会被修改
                if( cnt <= n) {
                    printNumber.accept(0);
                }
                current = (current + 1) % 2;
            } finally {
                lock.unlock();
            }
        }
        lock.lock();
        try {
            even.signal();
            odd.signal();
        } finally {
            lock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(; cnt <= n; ) {
            lock.lock();
            try {
                while( current == 0 || cnt % 2 != 0) {
                    zero.signal();
                    odd.signal();
                    even.await();
                }
                if( cnt <= n) {
                    printNumber.accept(cnt);
                    cnt++;
                }
                current = (current + 1) % 2;
            } finally {
                lock.unlock();
            }
        }
        lock.lock();
        try {
            zero.signal();
            odd.signal();
        } finally {
            lock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(; cnt <= n; ) {
            lock.lock();
            try {
                while( current == 0 || cnt % 2 == 0) {
                    zero.signal();
                    even.signal();
                    odd.await();
                }
                if( cnt <= n) {
                    printNumber.accept(cnt);
                    cnt++;
                }
                current = (current + 1) % 2;
            } finally {
                lock.unlock();
            }
        }
        lock.lock();
        try {
            zero.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        int n = 5;
//        int n = 6;
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        Thread t1 = new Thread(() -> {
            try {
                zeo.zero((x) -> {
                    System.out.print(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            try {
                zeo.even((x) -> {
                    System.out.print(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        Thread t3 = new Thread(() -> {
            try {
                zeo.odd((x) -> {
                    System.out.print(x);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3");
        t1.start();
        t2.start();
        t3.start();
    }

}
