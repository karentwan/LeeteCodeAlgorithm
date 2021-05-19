package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: O(1)时间插入、删除和获取随机元素
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class RandomizedSet {

    private Random random = new Random();

    private Map<Integer, Integer> map = new HashMap<>();

    private List<Integer> data = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if( !map.containsKey(val)) {
            data.add(val);
            map.put(val, data.size()-1);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if( map.containsKey(val)) {
            int idx = map.get(val);
            // 交换顺序就不用移动
            data.set(idx, data.get(data.size()-1));
            map.put(data.get(idx), idx);
            data.remove(data.size()-1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int idx = random.nextInt(data.size());
        return data.get(idx);
    }

    public static void main(String[] args) {

    }

}
