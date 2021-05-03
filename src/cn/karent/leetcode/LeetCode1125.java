package cn.karent.leetcode;

import java.util.*;
import cn.karent.util.*;

/**
 * 最小必要团队
 * dp的索引就是技能集合(例如索引7, 二进制表示为0111, 代表拥有三种技能)
 */
public class LeetCode1125 {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            skillMap.put(req_skills[i], i);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < (1<<n); i++) {
            list.add(new ArrayList<>());
        }
        // 定义dp
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i = 0; i < people.size(); i++) {
            List<String> person = people.get(i);
            int mask = 0;
            for(int j = 0; j < person.size(); j++) {
                int idx = skillMap.get(person.get(j));
                mask |= (1 << idx);
            }
            for(int j = 0; j < (1 << n); j++) {
                if( dp[j] >= 0) {  // 只有当前技能是合法的, 才能进行后续的计算
                    int newM = mask | j;
                    if( dp[newM] == -1 || dp[newM] > dp[j] + 1) {
                        List<Integer> tmp = list.get(newM);
                        tmp.clear();
                        tmp.addAll(list.get(j));
                        tmp.add(i);
                        dp[newM] = dp[j]+1;
                    }
                }
            }
        }
        List<Integer> person = list.get((1 << n) - 1);
        int[] rets = new int[person.size()];
        for(int i = 0; i < person.size(); i++) {
            rets[i] = person.get(i);
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1125 lc = new LeetCode1125();
//        System.out.println(1 << 25);
//        System.out.println(Math.pow(2, 25));
        String[] req_skills = {"java","nodejs","reactjs"};
        String[][] arr = {{"java"},{"nodejs"},{"nodejs","reactjs"}};
        List<List<String>> people = LeetCodeUtil.arr2list(arr);
        int[] rets = lc.smallestSufficientTeam(req_skills, people);
        for(int ret : rets) {
            System.out.print(ret + " ");
        }
        System.out.println();
    }
}
