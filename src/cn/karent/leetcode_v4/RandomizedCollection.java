package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: O(1)时间插入、删除和获取随机元素-允许重复
 * @author wan
 * @date 2021.05.20
 ********************************************/
public class RandomizedCollection {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private List<Integer> data = new ArrayList<>();
    private Random random = new Random();
    private int cnt;

    /** Initialize your data structure here. */
    public RandomizedCollection() {

    }

    private boolean add(int val, int idx) {
        List<Integer> list = map.computeIfAbsent(val, (key)->new ArrayList<>());
        list.add(idx);
        return list.size() == 1;
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        data.add(val);
        return add(val, cnt++);
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        List<Integer> idxs = map.getOrDefault(val, new ArrayList<>());
        if( idxs.size() > 0) {
            cnt--;
            // 最后一个元素的索引
            List<Integer> last = map.getOrDefault(data.get(data.size()-1), new ArrayList<>());
            // 如果待删除的元素和最后一个元素相等
            if( last == idxs) {  // 如果相等则直接删最后一个元素就可以
                last.remove(last.size()-1);
                data.remove(data.size()-1);
            } else {  // 如果不相等则交换位置然后删最后一个元素
                // 元素索引也要交换, 删除元素的索引放到最后一个元素所在List索引中
                int idx = idxs.get(idxs.size()-1);  // 要删除的元素的索引
                idxs.remove(idxs.size()-1);
                last.remove(last.size()-1);
                last.add(idx);
                // 满足插入有序
                int i = last.size()-2;
                while ( i >= 0 && last.get(i) > idx) {
                    last.set(i+1, last.get(i));
                    i--;
                }
                last.set(i+1, idx);
                // 交换位置
                data.set(idx, data.get(data.size()-1));
                data.remove(data.size()-1);
            }
            return true;
        }
        return false;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int idx = random.nextInt(cnt);
        if( idx < cnt) return data.get(idx);
        return -1;
    }

    public static void main(String[] args) {
        RandomizedCollection lc = new RandomizedCollection();
        lc.insert(1);
        lc.insert(1);
        lc.insert(2);
        lc.insert(2);
        lc.insert(2);
        lc.remove(1);
        lc.remove(1);
        lc.remove(2);
        lc.insert(1);
        lc.remove(2);
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
        System.out.println(lc.getRandom());
    }

    private static void m1() {
        RandomizedCollection lc = new RandomizedCollection();
        System.out.println(lc.insert(9));
        System.out.println(lc.insert(9));
        System.out.println(lc.insert(1));
        System.out.println(lc.insert(1));
        System.out.println(lc.insert(2));
        System.out.println(lc.insert(1));
        System.out.println(lc.remove(2));
        System.out.println(lc.remove(1));
        System.out.println(lc.remove(1));
        System.out.println(lc.insert(9));
        System.out.println(lc.remove(1));
    }

}
