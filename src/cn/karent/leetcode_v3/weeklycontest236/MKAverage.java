package cn.karent.leetcode_v3.weeklycontest236;

import java.util.*;

/**
 *
 * @author wan
 * @date 2021.04.11
 */
public class MKAverage {

    static class OrderTree<T> {
        private TreeMap<T, Integer> data;
        private int _size;

        public OrderTree() {
            data = new TreeMap<>();
            _size = 0;
        }

        public boolean isEmpty() {
            return data.isEmpty();
        }

        public void add(T x) {
            int v = 0;
            if (data.containsKey(x)) {
                v = data.get(x);
            }
            data.put(x, v+1);
            _size++;
        }

        public int size() {
            return _size;
        }

        public void remove(T x) {
            if( data.containsKey(x) ) {
                int v = data.get(x);
                if(v == 1) data.remove(x);
                else data.put(x, v-1);
                _size--;
            }
        }

        public boolean contains(T x) {
            return data.containsKey(x);
        }

        public T ceiling(T x) {
            return data.ceilingKey(x);
        }

        public T floor(T x) {
            return data.floorKey(x);
        }

        public T last() {
            return data.lastKey();
        }

        public T first() {
            return data.firstKey();
        }

    }

    private int m;
    private int k;

    private long sum = 0;

    private OrderTree<Integer> left = new OrderTree<>();
    private OrderTree<Integer> middle = new OrderTree<>();
    private OrderTree<Integer> right = new OrderTree<>();

    private LinkedList<Integer> que = new LinkedList<>();

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    private int left2right(OrderTree<Integer> left, OrderTree<Integer> right) {
        int key = left.last();
        left.remove(key);
        right.add(key);
        return key;
    }

    private int right2left(OrderTree<Integer> right, OrderTree<Integer> left) {
        int key = right.first();
        right.remove(key);
        left.add(key);
        return key;
    }

    public void addElement(int num) {
        // 开始添加
        que.offer(num);
        if( !left.isEmpty() && left.last() > num) left.add(num);
        else if( !right.isEmpty() && right.first() < num) right.add(num);
        else {
            middle.add(num);
            sum += num;
        }
        // 如果左右两边超过了k个元素则往中间移动
        while (left.size() > k) {
            int key = left2right(left, middle);
            sum += key;
        }
        while (right.size() > k) {
            int key = right2left(right, middle);
            sum += key;
        }
        // 如果元素数量超过了m个, 将前面的元素删掉
        while (que.size() > m) {
            int key = que.poll();
            if( left.contains(key)) left.remove(key);
            else if( right.contains(key)) right.remove(key);
            else {
                middle.remove(key);
                sum -= key;
            }
        }
        if( que.size() >= m) {
            // 删除后再判断left和right是否满足k个元素
            while (left.size() < k) {
                int key = right2left(middle, left);
                sum -= key;
            }
            while (right.size() < k) {
                int key = left2right(middle, right);
                sum -= key;
            }
        }
    }

    public int calculateMKAverage() {
        if( que.size() < m) return -1;
        return ((int) (sum / (m - 2 * k)));
    }


    public static void main(String[] args) {
//        test1();
        test2();
//        test3();
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
