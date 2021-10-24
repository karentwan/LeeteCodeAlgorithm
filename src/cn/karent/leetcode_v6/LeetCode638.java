package cn.karent.leetcode_v6;

import cn.karent.util.LeetCodeUtil;

import java.util.*;

/***********************************************
 * description: 大礼包
 * @author wan
 * @date 2021.10.24
 ***********************************************/
public class LeetCode638 {

    private Map<List<Integer>, Integer> memo = new HashMap<>();


    public int shoppingOffers(List<Integer> price, List<List<Integer>> specials, List<Integer> needs) {
        if (!memo.containsKey(needs)) {
            int min = 0;
            // 全部使用单价购买
            for (int i = 0; i < price.size(); i++) {
                min += price.get(i) * needs.get(i);
            }
            // 使用大礼包的情况
            for (int i = 0; i < specials.size(); i++) {
                List<Integer> special = specials.get(i);
                List<Integer> nxt = new ArrayList<>();
                for (int j = 0; j < needs.size(); j++) {
                    if (special.get(j) > needs.get(j)) break;
                    nxt.add(needs.get(j) - special.get(j));
                }
                if (nxt.size() == needs.size()) {
                    // 开始使用
                    min = Math.min(min, shoppingOffers(price, specials, nxt) + special.get(needs.size()));
                }
            }
            memo.put(needs, min);
        }
        return memo.get(needs);
    }

    public static void main(String[] args) {
        LeetCode638 lc = new LeetCode638();
        Integer[] price = {2, 5};
        Integer[][] special = {{3, 0, 5}, {1, 2, 10}};
        Integer[] needs = {3, 2};

        System.out.println(lc.shoppingOffers(LeetCodeUtil.arr2list(price), LeetCodeUtil.arr2list(special), LeetCodeUtil.arr2list(needs)));

    }

}
