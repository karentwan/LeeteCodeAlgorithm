package cn.karent.leetcode_v4;

import java.util.*;
import java.util.function.IntConsumer;

/********************************************
 * description: 交替打印字符串
 * @author wan
 * @date 2021.05.18
 ********************************************/
public class FizzBuzz {

    private int n;

    public FizzBuzz(int n) {
        this.n = n;
    }

    private int cnt = 1;

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while ( cnt <= n) {
            synchronized (this) {
//                while ( cnt <= n && (cnt % 3 != 0 || cnt % 15 == 0)) {
//                    this.notifyAll();
//                    this.wait();
//                }
                if( cnt <= n && !(cnt % 3 != 0 || cnt % 15 == 0)) {
                    printFizz.run();
                    cnt++;
                }
            }
        }
//        synchronized (this) {
//            notifyAll();
//        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while ( cnt <= n) {
            synchronized (this) {
//                while (cnt <= n && (cnt % 5 != 0 || cnt % 15 == 0)) {
//                    this.notifyAll();
//                    this.wait();
//                }
                if( cnt <= n && !(cnt % 5 != 0 || cnt % 15 == 0)) {
                    printBuzz.run();
                    cnt++;
                }
            }
        }
//        synchronized (this) {
//            this.notifyAll();
//        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (cnt <= n) {
            synchronized (this) {
//                while (cnt <= n && (cnt % 15 != 0)) {
//                    this.notifyAll();
//                    this.wait();
//                }
                if( cnt <= n && cnt % 15 == 0) {
                    printFizzBuzz.run();
                    cnt++;
                }
            }
        }
//        synchronized (this) {
//            this.notifyAll();
//        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (cnt <= n) {
            synchronized (this) {
//                while (cnt <= n && (cnt % 3 == 0 || cnt % 5 == 0)) {
//                    this.notifyAll();
//                    this.wait();
//                }
                if( cnt <= n && !(cnt % 3 == 0 || cnt % 5 == 0)) {
                    printNumber.accept(cnt);
                    cnt++;
                }
            }
        }
//        synchronized (this) {
//            this.notifyAll();
//        }
    }

    public static void main(String[] args) {
        int n = 15;
        FizzBuzz fb = new FizzBuzz(n);
        Runnable r1 = ()->{
            System.out.print("fizz ");
        };
        Runnable r2 = ()->{
            System.out.print("buzz ");
        };
        Runnable r3 = ()->{
            System.out.print("fizzbuzz ");
        };
        IntConsumer c = x -> {
            System.out.print(x + " ");
        };
        new Thread(()->{
            try {
                fb.fizz(r1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(()->{
            try {
                fb.buzz(r2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
        new Thread(()->{
            try {
                fb.fizzbuzz(r3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3").start();
        new Thread(()->{
            try {
                fb.number(c);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t4").start();
//        System.out.print("haaa");
    }

}
