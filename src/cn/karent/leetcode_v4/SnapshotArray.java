package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 快照数组
 * @author wan
 * @date 2021.05.25
 ********************************************/
public class SnapshotArray {

    private int snap_id;

    class Node {
        int val;
        int snap_id;

        public Node(int val, int snap_id) {
            this.val = val;
            this.snap_id = snap_id;
        }
    }

    private List[] data;

    public SnapshotArray(int length) {
        data = new List[length];
        for (int i = 0; i < length; i++) {
            data[i] = new ArrayList();
        }
    }

    // 找到小于等于snap_id的元素
    private int binarySearch(List list, int snap_id) {
        int l = 0, r = list.size()-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            Node n = ((Node) list.get(m));
            if( n.snap_id == snap_id) return m;
            else if( n.snap_id > snap_id) r = m - 1;
            else l = m + 1;
        }
        return r;
    }

    public void set(int index, int val) {
        List list = data[index];
        if( list.size() == 0 || ((Node) list.get(list.size() - 1)).snap_id < snap_id) {
            list.add(new Node(val, snap_id));
        } else {
            Node n = ((Node) list.get(list.size() - 1));
            n.val = val;
        }
    }

    public int snap() {
        snap_id++;
        return snap_id-1;
    }

    public int get(int index, int snap_id) {
        List list = data[index];
        int idx = binarySearch(list, snap_id);
        if( idx < 0) return 0;
        return ((Node) list.get(idx)).val;
    }

    public static void main(String[] args) {
        int n = 2;
        SnapshotArray lc = new SnapshotArray(n);
        lc.set(0, 8);
        System.out.println(lc.snap());
        lc.set(0, 9);
        System.out.println(lc.snap());
        System.out.println(lc.snap());
        lc.set(0, 11);
        System.out.println(lc.snap());
        System.out.println(lc.get(1, 1));
        System.out.println(lc.snap());
        System.out.println(lc.snap());
        lc.set(0, 1);
        System.out.println(lc.snap());
        System.out.println(lc.get(0, 1));
        lc.set(0, 0);
        System.out.println(lc.snap());
    }

    private static void m1() {
        int n = 1;
        SnapshotArray lc = new SnapshotArray(n);
        lc.set(0, 15);
        System.out.println(lc.snap());
        System.out.println(lc.snap());
        System.out.println(lc.snap());
        System.out.println(lc.get(0, 2));
        System.out.println(lc.snap());
        System.out.println(lc.snap());
        System.out.println(lc.get(0, 0));
    }

}
