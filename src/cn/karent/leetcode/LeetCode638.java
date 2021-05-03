package cn.karent.leetcode;

import java.util.*;

/**
 * 大礼包
 */
public class LeetCode638 {

    private int dot(List<Integer> price, List<Integer> needs) {
        int ret = 0;
        for(int i = 0; i < price.size(); i++) {
            ret += price.get(i) * needs.get(i);
        }
        return ret;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int ret = dot(price, needs);
        for(List<Integer> parcel : special) {
            boolean valid = true;
            for(int i = 0; i < needs.size(); i++) {
                if( parcel.get(i) > needs.get(i)) {
                    valid = false;
                    break;
                }
            }
            if( valid ) {
                // choice
                for(int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i)-parcel.get(i));
                }
                ret = Math.min(ret, parcel.get(parcel.size()-1) + shoppingOffers(price, special, needs));
                // unchoice
                for(int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i)+parcel.get(i));
                }
            }
        }
        return ret;
    }

}
