package cn.karent.leetcode_v5;

import java.util.*;

/***********************************************
 * description: Fizz Buzz
 * @author wan
 * @date 2021.06.30
 ***********************************************/
public class LeetCode412 {

    public List<String> fizzBuzz(int n) {
        List<String> rets = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if( i % 15 == 0) rets.add("FizzBuzz");
            else if( i % 3 == 0) rets.add("Fizz");
            else if( i % 5 == 0) rets.add("Buzz");
            else rets.add(i + "");
        }
        return rets;
    }

    public static void main(String[] args) {

    }

}
