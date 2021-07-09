package cn.karent.leetcode_v6;

import java.util.*;

/***********************************************
 * description: 主要元素
 *              摩尔计数
 * @author wan
 * @date 2021.07.09
 ***********************************************/
public class Offer1710 {

    public int majorityElement(int[] nums) {
        int ret = 0, cnt = 0;
        for (int num : nums) {
            if( cnt == 0) {
                ret = num;
                cnt++;
            } else if( num == ret) cnt++;
            else cnt--;
        }
        cnt = 0;
        for (int num : nums) {
            if( num == ret) cnt++;
        }
        return cnt > nums.length / 2 ? ret : -1;
    }

    public static void main(String[] args) {

    }

}
