package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: RLE迭代器
 * @author wan
 * @date 2021.05.14
 ********************************************/
public class RLEIterator {

    class Node {
        private long data;
        private long idx;

        public Node(int data, long idx) {
            this.data = data;
            this.idx = idx;
        }
    }

    private List<Node> data;

    private long idx;

    private long length;

    public RLEIterator(int[] encoding) {
        data = new ArrayList<>();
        long idx = 0;
        for (int i = 0; i+1 < encoding.length; i+=2) {
            int n = encoding[i];
            int d = encoding[i+1];
            if( n == 0) continue;
            idx = idx + n;
            Node node = new Node(d, idx-1);
            data.add(node);
            length += n;
        }
    }

    private int binarySearch(long target) {
        int l = 0, r = data.size()-1;
        while (l < r) {
            int m = l + (r-l)/2;
            Node n = data.get(m);
            if( n.idx >= target) r = m;
            else l = m+1;
        }
        return l;
    }

    public int next(int n) {
        idx += n;
        if( idx > length) return -1;
        int i = binarySearch(idx-1);
        return ((int) data.get(i).data);
    }

    public static void main(String[] args) {
//        m1();
        int[] arr = {923381016,843,898173122,924,540599925,391,705283400,275,811628709,850,895038968,590,949764874,580,450563107,660,996257840,917,793325084,82};
        RLEIterator lc = new RLEIterator(arr);
        System.out.println(lc.next(612783106));
//        System.out.println(lc.next(1));
//        System.out.println(lc.next(1));
//        System.out.println(lc.next(2));
    }

    private static void m1() {
        int[] arr = {3, 8, 0, 9, 2, 5};
        RLEIterator lc = new RLEIterator(arr);
        System.out.println(lc.next(2));
        System.out.println(lc.next(1));
        System.out.println(lc.next(1));
        System.out.println(lc.next(2));
    }

}
