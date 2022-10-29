package cn.karent.leetcode_v7;

import java.util.*;

/******************************************
 * 统计匹配检索规则的物品数量
 * @author wan
 * @date 2022.10.29 09:27
 ******************************************/
public class LeetCode1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ret = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    ret += ruleValue.equals(item.get(0)) ? 1 : 0;
                    break;
                case "color":
                    ret += ruleValue.equals(item.get(1)) ? 1 : 0;
                    break;
                case "name":
                    ret += ruleValue.equals(item.get(2)) ? 1 : 0;
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode1773 lc = new LeetCode1773();

    }

}
