package cn.karent.leetcode_v4;

import java.util.*;

/********************************************
 * description: 最小绝对差
 * @author wan
 * @date 2021.05.19
 ********************************************/
public class LeetCode1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i] - arr[i-1], min);
        }
        List<List<Integer>> rets = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if( arr[i] - arr[i-1] == min) {
                rets.add(Arrays.asList(arr[i-1], arr[i]));
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        LeetCode1200 lc = new LeetCode1200();
//        int[] arr = {4, 2, 1, 3};
        int[] arr = {1,3,6,10,15};
        List<List<Integer>> rets = lc.minimumAbsDifference(arr);
        System.out.println(rets);
    }

}
