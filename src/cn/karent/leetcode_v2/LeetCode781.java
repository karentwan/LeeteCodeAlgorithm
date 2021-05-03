package cn.karent.leetcode_v2;

import java.util.*;

import cn.karent.util.*;


/**
 * 森林中的兔子
 * @author wan
 * @date 2021.04.04
 */
public class LeetCode781 {

    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int i = 0;
        int ret = 0;
        while (i < answers.length ) {
            int t = answers[i];
            int cnt = answers[i]+1;
            ret += cnt;
            while (i < answers.length && answers[i] == t && cnt > 0) {
                i++;
                cnt--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        LeetCode781 lc = new LeetCode781();
        int[] answers = {10, 10, 10};
        int ret = lc.numRabbits(answers);
        System.out.println(ret);
    }

}
