package cn.karent.interview;

import java.util.*;
import cn.karent.util.*;

/***********************************************
 * description: 求组合数为固定值的组合所有下标数
 * @author wan
 * @date 2021.06.19
 ***********************************************/
public class Offer1123 {

    public List<List<Integer>> solution(int[] arr, int target) {
        int n = arr.length;
        int[][] tmps = new int[n][2];
        for (int i = 0; i < n; i++) {
            tmps[i][0] = arr[i];
            tmps[i][1] = i;
        }
        Arrays.sort(tmps, (k1, k2)-> k1[0] - k2[0]);
        List<List<Integer>> rets = new ArrayList<>();
        for (int i = 0, j = n-1; i < j; ) {
            while (i > 0 && i < j && tmps[i][0] == tmps[i-1][0]) i++;
            while ( j < n-1 && i < j && tmps[j][0] == tmps[j+1][0])j--;
            if( i == j) break;
            int[] k1 = tmps[i];
            int[] k2 = tmps[j];
            int k = k1[0] + k2[0];
            if( k == target) {
                rets.add(Arrays.asList(k1[1], k2[1]));
                i++;
                j--;
            } else if( k > target) j--;
            else i++;
        }
        return rets;
    }

    public static void main(String[] args) {
        Offer1123 lc = new Offer1123();
        int[] arr = {1,2,5,7,8,8,9,4,4,6};
        int target = 12;
        List<List<Integer>> rets = lc.solution(arr, target);
        System.out.println(rets);
    }

}
