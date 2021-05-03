package cn.karent.leetcode_v3.weeklycontest236;

import java.util.*;

/**
 *
 * @author wan
 * @date 2021.04.11
 */
public class MKAverage {

    class OrderTree<T> {

        private TreeMap<T, Integer> map = new TreeMap<>();

        private int _size = 0;

        public void add(T key) {
            map.put(key, map.getOrDefault(key, 0)+1);
            _size++;
        }

        public int size() {
            return _size;
        }

        public void remove(T key) {
            _size--;
//            map.put(key, map.get(key)-1);
//            if( map.get(key) == 0) {
//                map.remove(key);
//            }
            int cnt = map.getOrDefault(key, 0);
            if( cnt == 0) {
                System.out.println("key cnt = 0:" + key);
            }
            if( cnt == 1) {
                map.remove(key);
            } else {
                map.put(key, cnt-1);
            }
        }

        public boolean contains(T o) {
            return map.containsKey(o);
        }

        public T pollFirst() {
            T e = first();
            remove(e);
            return e;
        }

        public T pollLast() {
            T e = last();
            remove(e);
            return e;
        }

        public T first() {
            return map.firstKey();
        }

        public T last() {
            return map.lastKey();
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public void traverse() {
            for (T e : map.keySet()) {
                int value = map.get(e);
                if( value == 2) {
                    System.out.print(e + " ");
                }
//                System.out.print( value + " ");
            }
        }

        public int sum() {
            int ret = 0;
            for(T e : map.keySet()) {
                ret += (Integer)e;
            }
            return ret;
        }

    }

    private OrderTree<Integer> left = new OrderTree<>();
    private OrderTree<Integer> middle = new OrderTree<>();
    private OrderTree<Integer> right = new OrderTree<>();
    private Deque<Integer> que = new LinkedList<>();

    private int m;
    private int k;

    private long sum = 0;

    private int cnt = 0;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    private int shiftLeft(OrderTree<Integer> left, OrderTree<Integer> right) {
        int e = right.pollFirst();
        left.add(e);
        return e;
    }

    private int shiftRight(OrderTree<Integer> left, OrderTree<Integer> right) {
        int e = left.pollLast();
        right.add(e);
        return e;
    }

    public void addElement(int num) {
        que.offer(num);
        cnt++;
        if ( left.isEmpty() || left.first() >= num) {
            left.add(num);
        } else if( right.isEmpty() || right.last() <= num) {
            right.add(num);
        } else {
            middle.add(num);
            sum += num;
        }
        // 保证元素的个数
        while (left.size() > k) {
            int e = shiftRight(left, middle);
            sum += e;
        }
        while (right.size() > k) {
            int e = shiftLeft(middle, right);
            sum += e;
        }
        if( que.size() > m) {
            int e = que.pollFirst();
            if( left.contains(e) ) {
                left.remove(e);
            } else if( middle.contains(e)) {
                middle.remove(e);
                sum -= e;
            } else {
                right.remove(e);
            }
        }
        // 调整
        if( que.size() >= m) {
            while (left.size() < k) {
                int e = shiftLeft(left, middle);
                sum -= e;
            }
            while (right.size() < k) {
                int e = shiftRight(middle, right);
                sum -= e;
            }
        }
    }

    public int calculateMKAverage() {
        if( cnt < m) {
            return -1;
        }
        ////////////////////
//        int _s = left.map.size();
//        if( _s == 99) {
//            left.traverse();
//            System.out.println(left.map.get(5299));
//        }
//        System.out.println(middle.sum() + "\tsum:" + sum);
        ///////////
        double ret = sum * 1.0 / (m - 2 * k);
        return ((int) ret);
    }

    public static void main(String[] args) {
//        test1();
//        test2();
        test3();
//        System.out.println(ts.pollFirst());
//        System.out.println(ts.pollLast());
    }

    private static void test3() {
        MKAverage mk = new MKAverage(10, 4);
        mk.addElement(1);
        mk.addElement(2);
        mk.addElement(3);
        mk.addElement(4);
        mk.addElement(5);
        mk.addElement(6);
        mk.addElement(7);
        mk.addElement(8);
        mk.addElement(9);
        mk.addElement(10);
        System.out.println(mk.calculateMKAverage());
    }

    private static void test2() {
        MKAverage mk = new MKAverage(30, 10);
        mk.addElement(87859);
        mk.addElement(24884);
        mk.addElement(39764);
        mk.addElement(37246);
        mk.addElement(77016);
        mk.addElement(65453);
        mk.addElement(66229);
        mk.addElement(51558);
        mk.addElement(77202);
        mk.addElement(4526);
        ////------------------10
        mk.addElement(62945);
        mk.addElement(31817);
        mk.addElement(97483);
        mk.addElement(52991);
        mk.addElement(54305);
        mk.addElement(87130);
        mk.addElement(22677);
        mk.addElement(48120);
        mk.addElement(71933);
        mk.addElement(92149);
        // -------------------------------
        mk.addElement(88407);
        mk.addElement(96760);
        mk.addElement(49114);
        mk.addElement(11334);
        mk.addElement(57536);
        mk.addElement(87001);
        mk.addElement(66641);
        mk.addElement(14147);
        mk.addElement(21457);
        mk.addElement(68281);
        System.out.println(mk.calculateMKAverage());
        //----------------------------------30
        mk.addElement(51545);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(48566);
        mk.addElement(64186);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(96046);
        mk.addElement(3877);
        mk.addElement(64515);
        mk.addElement(5700);
        mk.addElement(40440);
        mk.addElement(92194);
        mk.addElement(80585);
        //---------------------------------40
        mk.addElement(77750);
        mk.addElement(75783);
        mk.addElement(51590);
        mk.addElement(84825);
        mk.addElement(22329);
        mk.addElement(22098);
        mk.addElement(65830);
        mk.addElement(29746);
        mk.addElement(1613);
        mk.addElement(26152);
        //-------------------------------------50
        mk.addElement(70729);
        mk.addElement(71872);
        mk.addElement(30432);
        mk.addElement(53013);
        mk.addElement(67342);
        mk.addElement(45066);
        mk.addElement(75733);
        mk.addElement(46305);
        mk.addElement(60180);
        mk.addElement(35295);
        //------------------------------------60
        mk.addElement(86405);
        mk.addElement(71827);
        mk.addElement(79816);
        mk.addElement(95604);
        mk.addElement(749);
        mk.addElement(50291);
        mk.addElement(97060);
    }

    private static void test1() {
        MKAverage mk = new MKAverage(3, 1);
        mk.addElement(3);
        mk.addElement(1);
        System.out.println(mk.calculateMKAverage());
        mk.addElement(10);
        System.out.println(mk.calculateMKAverage());

        mk.addElement(5);
        mk.addElement(5);
        mk.addElement(5);
        System.out.println(mk.calculateMKAverage());
    }

}
