package cn.karent.leetcode_v2.weeklycontest235;

import java.util.*;
import cn.karent.util.*;

/**
 * 序列中不同最大公约数的数目
 * @author wan
 * @date 2021.04.04
 */
public class Algo5725 {
/*
    private Set<Integer> set = new HashSet<>();

    private int gcd(List<Integer> list, int g) {
        int ret = 1;
        if( list.size() == 1) {
            ret = list.get(0);
            set.add(list.get(0));
        } else {
            ret = 1;
            for (int i = Math.min(list.get(0) + 1, g); i >= 2; i--) {
                boolean flag = true;
                for (int j = 0; j < list.size() && flag; j++) {
                    if( list.get(j) % i != 0) {
                        flag = false;
                    }
                }
                if( flag ) {
                    ret = i;
                    break;
                }
            }
            set.add(ret);
        }
        return ret;
    }

    private void dfs(int[] nums, int idx, int g, List<Integer> list) {
        for (int i = idx; i < nums.length; i++) {
            if( i == idx || nums[i] != nums[i-1]) {
                list.add(nums[i]);
                int t = gcd(list, g);
                dfs(nums, i+1, t, list);
                list.remove(list.size()-1);
            }
        }
    }
    // 超时
    public int countDifferentSubsequenceGCDs(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, Integer.MAX_VALUE, list);
        return set.size();
    }

   */

    private int _gcd(int a, int b) {
        return b == 0 ? a : _gcd(b, a %b);
    }

    private int gcd(int a, int b) {
        if( a < b) {
            int t = a;
            a = b;
            b = t;
        }
        return _gcd(a, b);
    }

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int[] set = new int[200010];
        int m = 0;
        for (int num : nums) {
            m = Math.max(num, m);
            set[num] = 1;
        }
        int ret = 0;
        for (int i = 1; i <= m; i++) {
            int g = -1;
            /*
            假设当前的最大公约数为i, 首先找出数组里面所有i的倍数的元素, 然后求它们的最大公约数
            如果它们的最大公约数刚好是i, 那么就不用找了, 因为其他元素加进来最大公约数只会更小不会更大
             */
            for (int x = i; x <= m; x += i) {
                if( set[x] == 1) {
                    if( g == -1) {
                        g = x;
                    } else {
                        g = gcd(g, x);
                    }
                    if( g == i) {
                        ret++;
                        break;
                    }
                }
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = {6,10,3};
//        int[] nums = {5,15,40,5,6};
        Algo5725 algo = new Algo5725();
        int ret = algo.countDifferentSubsequenceGCDs(nums);
        System.out.println(ret);
    }

}
