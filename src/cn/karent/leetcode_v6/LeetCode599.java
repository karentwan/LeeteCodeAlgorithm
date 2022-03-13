package cn.karent.leetcode_v6;

import java.util.*;

/*******************************************
 * @author wan
 * @date: 2022-03-14 07:40
 * @description: 两个列表的最小索引和
 *******************************************/
public class LeetCode599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            if (!map.containsKey(list1[i]))
                map.put(list1[i], i);
        }
        int minIdx = Integer.MAX_VALUE;
        List<String> rets = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i]) && i + map.get(list2[i]) <= minIdx) {
                if (map.get(list2[i]) + i < minIdx) {
                    rets.clear();
                    minIdx = map.get(list2[i]) + i;
                }
                rets.add(list2[i]);
            }
        }
        return rets.toArray(new String[rets.size()]);
    }

    public static void main(String[] args) {
        LeetCode599 lc = new LeetCode599();
//        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
//        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] rets = lc.findRestaurant(list1, list2);
        for (String ret : rets) {
            System.out.println(ret);
        }
    }

}
